/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Croupier;
import modelo.Efecto;
import modelo.Mesa;
import modelo.Fachada;
import modelo.Ronda;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author feder
 */
public class ControladorOperarMesa implements Observador {
    private VistaOperarMesa vista;    
    private Croupier croupier;
    private Mesa mesa;

    public ControladorOperarMesa(VistaOperarMesa vista, Croupier croupier) {
        this.vista = vista;
        this.croupier = croupier;
        this.mesa = croupier.getMesa();
        mesa.agregarObservador(this); 
        
        cargarMesa();
        
    }
    public void salir(){
        mesa.quitarObservador(this);
        mesa.cerrarMesa();
        Fachada.getInstancia().logout(croupier);
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Mesa.eventos.cambioJugador))actualizarJugadores();
        if(evento.equals(Mesa.eventos.pagoRonda)){
            mostrarEstadisticas();
            actualizarJugadores();
        }
        if(evento.equals(Mesa.eventos.agregoApuesta)){
            actualizarTablero();
            actualizrRondaActual();
            actualizarJugadores();
        }
        if(evento.equals(Mesa.eventos.actualizarSaldo)){
            actualizarJugadores();
        }
    }
    

    private void cargarMesa() {
        vista.cargarEfectos(Fachada.getInstancia().getEfectos());
        vista.cargarNumRuleta(mesa.getNumMesa());
        //vista.mostrarOcultarCasilleros(mesa.getRondaActual().getCasilleros());
        actualizarJugadores();
        mostrarEstadisticas();
    }

    private void actualizarJugadores() {
        vista.actualizarJugadores(mesa.getJugadoresEnMesa());
    }

    private void mostrarEstadisticas() {
       vista.actualizarBalance(mesa.getBalance());
       vista.actualizarRonda(mesa.getRondaActual().getNumeroRonda());
       actualizarTablero();
       actualizrRondaActual();
    }
    public void actualizrRondaActual(){
        vista.actualizarRondaActual(mesa.getRondaActual().getTotalApuestas(), mesa.getRondaActual().getTotalApostado());
    }

    public void lanzarPagar(Efecto efecto, boolean salir) {
        if(salir && !mesa.estaPausada()) lanzarPagar(efecto, false);
        if(!mesa.estaPausada()){            
            mesa.lanzarBola(efecto);
            vista.actualizarUltimoNumero(mesa.getRondaActual().getNumeroGanador());
        } else {
            mesa.pagarRonda(salir);
        }
        if(salir){
            salir();
        }
    }
    
    private void actualizarTablero() {        
        vista.mostrarApuestas(mesa.getRondaActual().getCasilleros());
        vista.actualizarTablaRondas(cargarDatosTabla());
    }
    private ArrayList<String> cargarDatosTabla(){
        ArrayList<String> datos = new ArrayList();
        int balance = 0;
        for(Ronda r: mesa.getRondas()){
            datos.add(r.getNumeroRonda() + "");
            datos.add(balance + "");
            datos.add(r.getTotalApuestas() + "");
            datos.add(r.getRecoleccion()+ "");
            datos.add(r.getLiquidacion()+ "");
            balance = (int) (balance + r.getTotalApostado() - r.getLiquidacion());
            datos.add(balance + "");            
        }
        return datos;
    }
}
