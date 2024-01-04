/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author feder
 */
public class Ronda {
    private ArrayList<Casillero> casilleros;
    private ArrayList<Apuesta> apuestas;
    private int numeroGanador = -1;
    private int numeroRonda;
    private double liquidacion;
    private Mesa laMesa;

    public void setNumeroGanador(int numeroGanador) {
        if(this.numeroGanador == -1){
            this.numeroGanador = numeroGanador;
        }        
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public double getBalanceRonda() {
        return getTotalApostado() - liquidacion;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public int getNumeroGanador() {
        return numeroGanador;
    }
    
   
    
    
    
    public Ronda(ArrayList<TipoApuesta> tiposApuesta, int numeroRonda, Mesa m){
        casilleros = new ArrayList();
        apuestas = new ArrayList();
        this.laMesa = m;
        for(TipoApuesta tp: tiposApuesta){
            ArrayList<Casillero> casillero = tp.crearCasilleros();
            casilleros.addAll(casillero);            
        }
        this.numeroRonda = numeroRonda;
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    void pagarRonda() {
        for(Apuesta a: apuestas){
            if(a.getElCasillero().esGanador(this.numeroGanador)){
                liquidacion += a.pagar(a.getElCasillero().getFactorDePago());
            }
        }       
        
    }
    public int getTotalApuestas(){
        return apuestas.size();
    }
    public double getTotalApostado(){
        double total = 0;
        for(Apuesta a: apuestas){
            total += a.getValor();
        }
        return total;
    }

    

    public void agregarApuesta(Jugador jugador, int universalCellCode, int ficha) throws RuletaException{
        if(laMesa.estaPausada()){
            throw new RuletaException("La mesa esta pausada");  
        }
        
        if(jugador.getSaldo() < ficha){
            throw new RuletaException("Saldo insuficiente");            
        }
        boolean encontro = false;
        for(Apuesta a: apuestas){
            if(a.getJugador().equals(jugador) && a.getElCasillero().getUcc() == universalCellCode){
                a.setValor(a.getValor() + ficha);
                if(a.getElCasillero().aplicaRestriccion(a, laMesa)){
                    a.setValor(a.getValor() - ficha);
                    throw new RuletaException("No se puede efectuar la apuesta por las restricciones.");
                } 
                
                encontro = true;
                jugador.restarApuesta(ficha);
            }
        }
        if(!encontro){
            agregarNuevaApuesta(jugador, universalCellCode, ficha);
        }
        
        laMesa.avisar(Mesa.eventos.agregoApuesta);
    }
    
    private Casillero getCasillero(int ucc){
        Casillero elCasillero = null;
        for(Casillero c: casilleros){            
            if(c.getUcc() == ucc){
                elCasillero = c;
            }
        }
        return elCasillero;
    }

    private void agregarNuevaApuesta(Jugador jugador, int universalCellCode, int ficha) throws RuletaException{
        Casillero c = getCasillero(universalCellCode);
        Apuesta nuevaApuesta = new Apuesta(ficha,c ,jugador);
        
        if(c == null){
            throw new RuletaException("El casillero no esta disponible"); 
        } else if(c.aplicaRestriccion(nuevaApuesta, laMesa)){
            throw new RuletaException("No se puede efectuar la apuesta por las restricciones.");
        }else{
            apuestas.add(nuevaApuesta);
            c.agregarApuesta(nuevaApuesta);
            jugador.restarApuesta(ficha);
        }
        
    }

    public Double getRecoleccion() {
        double recoleccion = 0;
        for(Apuesta a: apuestas){
            if(!a.getElCasillero().esGanador(numeroGanador)){
                recoleccion += a.getValor();
            }
        }
        return recoleccion;
    }

    public double getLiquidacion() {        
        return this.liquidacion;
    }

    public ArrayList<Integer> getEstadisticasJugador(Jugador jugador) {
        ArrayList<Integer> estadisticas = new ArrayList();
        int apostado = 0;
        int ganado = 0;
        int perdido = 0;

        for(Apuesta a: apuestas){
            if(a.getJugador().equals(jugador)){
                apostado += a.getValor();
                if(a.getElCasillero().esGanador(this.numeroGanador)){
                    ganado += a.getValor() * a.getElCasillero().getFactorDePago();
                } else {
                    perdido += a.getValor();
                }                
            }
        }
        estadisticas.add(apostado);
        estadisticas.add(ganado);
        estadisticas.add(perdido);
        
        return estadisticas;
    }

    boolean tieneApuestas(Jugador j) {
      
        for(Apuesta a: apuestas){
            if(a.getJugador().equals(j)) return true;
        }
        return false;
    }

    
}
