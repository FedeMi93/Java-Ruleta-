/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.*;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author feder
 */
public class ControladorJugarMesa implements Observador{
    private VistaJugarMesa vista;
    private Jugador jugador;
    private Mesa mesa;

    public ControladorJugarMesa(VistaJugarMesa v, Jugador j, Mesa m){
        this.vista = v;
        this.mesa = m;
        this.jugador = j;
        m.agregarObservador(this);
        cargarDatos();
    }
    
    public void salir(){
        try{
            mesa.quitarJugador(jugador);
            mesa.quitarObservador(this);
            vista.cerrar();
        }catch (RuletaException re){
            vista.error(re.getMessage());
        }
        
        
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Mesa.eventos.pagoRonda)){
            actualizarSaldo();
            actualizarRonda();
            actualizarTablas();
            vista.limpiar();
        }
        if(evento.equals(Mesa.eventos.actualizarSaldo)){
            vista.actualizarSaldo(this.jugador.getSaldo());            
        }
        if(evento.equals(Mesa.eventos.cerroMesa))vista.cerroMesa("El croupier cerro la mesa.");
    
    }

    private void cargarDatos() {
        vista.cargarNombreCompleto(jugador.getNombreCompleto());
        actualizarSaldo();
        actualizarRonda();        
    }

    private void actualizarSaldo() {
        vista.actualizarSaldo(jugador.getSaldo());
    }

    private void actualizarRonda() {
        vista.actualizarMesaRonda(mesa.getNumMesa(), mesa.getRondaActual().getNumeroRonda());
    }

    private void actualizarTablas() {
       actualizarOcurrencia();
       actualizarEstadisticasJugador();
    }

    public void agrgarApuesta(int universalCellCode, int ficha) {
        try{
            mesa.getRondaActual().agregarApuesta(jugador, universalCellCode, ficha);
            mostrarApuestas();
            actualizarSaldo();
        }catch(RuletaException re){
            vista.error(re.getMessage());
        }
        
    }

    private void mostrarApuestas() {
        ArrayList<Apuesta> apuestas = new ArrayList();
        for(Apuesta a: mesa.getRondaActual().getApuestas()){
            if(a.getJugador().equals(jugador))apuestas.add(a);
        }
        vista.mostrarApuestas(apuestas);
    }

    private void actualizarOcurrencia() {
        ArrayList<Integer> ocurrencia = new ArrayList();
        ArrayList<Integer> numeros = new ArrayList();
        ArrayList<Ronda> rondas = mesa.getRondas();
        for(Ronda r: rondas){
            int ganador = r.getNumeroGanador();
            if(!numeros.contains(ganador)){
                numeros.add(ganador);
                ocurrencia.add(ganador);
                ocurrencia.add(1);
            }else{
                int posicion = ocurrencia.indexOf(ganador);
                int actual = ocurrencia.get(posicion + 1);
                ocurrencia.set(posicion + 1, actual + 1); 
            }            
        }
        for(int i=1; i < ocurrencia.size(); i += 2){
            int veces = ocurrencia.get(i);
            int porcentaje = (veces* 100/rondas.size());
                ocurrencia.set(i, porcentaje);
        }
        vista.mostrarValorOcurrencia(ocurrencia);
    }

    private void actualizarEstadisticasJugador() {
        ArrayList<Ronda> rondas = mesa.getRondas();
        ArrayList<String> estadisticas = new ArrayList();
        for(Ronda r: rondas){
            estadisticas.add(r.getNumeroRonda() + "");
            ArrayList<Integer> estadisticasJugador = r.getEstadisticasJugador(jugador);
            int apostado = estadisticasJugador.get(0);
            int ganado = estadisticasJugador.get(1);
            int perdido = estadisticasJugador.get(2);
            int balance = ganado - apostado;
            
            
            estadisticas.add(apostado + "");
            estadisticas.add(ganado + "");
            estadisticas.add(perdido + "");
            estadisticas.add(balance + "");
            
            vista.mostrarEstadisticasjugador(estadisticas);
            
        }
    }
    
    
}
