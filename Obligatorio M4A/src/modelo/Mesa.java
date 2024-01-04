/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;
import observador.Observable;

/**
 *
 * @author feder
 */
public class Mesa extends Observable{
    private boolean estaActiva;
    private ArrayList<Jugador> jugadoresEnMesa;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActual;
    private ArrayList<TipoApuesta> tiposDeApuestas;    
    private double balance;
    private int numeroRonda = 0;
    private int numMesa;
    private static int numMesaclass = 1;
    private boolean estaPausada;
    
    public enum eventos{pagoRonda, cambioJugador, cerroMesa, abrioMesa, agregoApuesta, actualizarSaldo}

    public Mesa() {
        jugadoresEnMesa = new ArrayList();
        rondas = new ArrayList();
        tiposDeApuestas = new ArrayList();
        numMesa = numMesaclass++;
    }

    public boolean estaPausada() {
        return estaPausada;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public ArrayList<Jugador> getJugadoresEnMesa() {
        return jugadoresEnMesa;
    }

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
    
    

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Ronda getRondaActual() {
        return rondaActual;
    }   

    
    public void agregarJugador(Jugador j) throws RuletaException{
        if(!jugadoresEnMesa.contains(j)){
            jugadoresEnMesa.add(j);
            avisar(eventos.cambioJugador);
            j.agregarMesa(this);
        } else throw new RuletaException("El jugador ya se encuentra en la mesa."); 
    }
    public void quitarJugador(Jugador j)throws RuletaException{
        if(jugadoresEnMesa.contains(j)){
            if(rondaActual.tieneApuestas(j) && !estaPausada){
                throw new RuletaException("No puede abandonar hasta completar la ronda.");
            }
            jugadoresEnMesa.remove(j);
            avisar(eventos.cambioJugador);
            j.quitarMesa(this);
        }
    }
    public void cerrarMesa(){
        if(estaPausada){
            for(Jugador j: jugadoresEnMesa){
                j.quitarMesa(this);
            }
            jugadoresEnMesa.clear();
            estaActiva = false;
            avisar(eventos.cerroMesa);
            Fachada.getInstancia().avisar(Fachada.eventos.cambioMesa);        
        }        
    }

    void iniciar(ArrayList<TipoApuesta> tiposApuesta) {
        this.tiposDeApuestas = tiposApuesta;
        this.estaActiva = true;
        iniciarRonda();
        Fachada.getInstancia().avisar(Fachada.eventos.cambioMesa);
    }
    public void iniciarRonda(){
        reanudarMesa();
        numeroRonda++;
        this.rondaActual = new Ronda(this.tiposDeApuestas, numeroRonda, this);
       
    }
    public void lanzarBola(Efecto unEfecto){
        pausarMesa();
        Random random = new Random();
        // Generar un número aleatorio entre 0 y 36
        int numero = random.nextInt(37);
        while(!unEfecto.esNumeroValido(numero, this)){
            numero = random.nextInt(37);
        }
        rondaActual.setNumeroGanador(numero);             
    }
    public void pagarRonda(boolean salir){
        rondaActual.pagarRonda();
        double balanceRonda = rondaActual.getBalanceRonda();
        balance += balanceRonda;
        avisar(eventos.pagoRonda);
        rondas.add(rondaActual);
        if(!salir){
            iniciarRonda();
        } 
        avisar(eventos.pagoRonda);
        
    }
    public Ronda getUltimaRonda(){
        if(!rondas.isEmpty())return rondas.get(rondas.size()-1);
        return null;        
    }

    private void pausarMesa() {
        this.estaPausada = true;
    }

    private void reanudarMesa() {
        this.estaPausada = false;
    }
    
    
}
