/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.Jugador;
import modelo.Mesa;
import modelo.RuletaException;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author feder
 */
public class ControladorElegirMesa implements Observador{
    private VistaElegirMesa vista;
    private Jugador elJugador;
    
    public ControladorElegirMesa(VistaElegirMesa vista, Jugador j){
        this.vista = vista;
        this.elJugador = j;
        mostrarMesasHabilitadas();
        Fachada.getInstancia().agregarObservador(this);
        //agrgar escuchador fachada para ver las mesas habilitadas
    }

    private void mostrarMesasHabilitadas() {
        vista.mostrarMesas(Fachada.getInstancia().getMesasHabilitadas());
    }

    public void unirseAMesa(Mesa m) {
        try{
            if(m == null){
                vista.error("No se selecciono una mesa");
            }else{
                m.agregarJugador(elJugador);
                vista.proximoCasoUso(elJugador, m);
            }            
        }catch (RuletaException re){
            vista.error(re.getMessage());
        }
    }

    public void salir() {
       //sacar la escucha
       Fachada.getInstancia().logout(elJugador);
       Fachada.getInstancia().quitarObservador(this);       
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Fachada.eventos.cambioMesa))mostrarMesasHabilitadas();
        
    }
}
