/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author feder
 */
public class Fachada extends Observable{
    private static Fachada instancia = new Fachada();

    private SistemaJuego sJuego = new SistemaJuego();
    private SistemaUsuario sUsuario = new SistemaUsuario();
    
    public enum eventos{cambioMesa};
        
    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }
    
    public Croupier loginCrupier(int cedula, String password) throws RuletaException{
        return sUsuario.loginCrupier(cedula, password);
    }
    public Jugador loginJugador(int cedula, String password) throws RuletaException{
        return sUsuario.loginJugador(cedula, password);
    }


    public ArrayList<TipoApuesta> getTiposDeApuesta() {
        return sJuego.getTiposDeApuesta();
    }

    public ArrayList<Efecto> getEfectos() {
        return sJuego.getEfectos();
    }

    public void agregarTipoApuesta(TipoApuesta t) {
        sJuego.agregarTipoApuesta(t);
    }

    public void agregarEfecto(Efecto e) {
        sJuego.agregarEfecto(e);
    }

    public void agregarCroupier(Croupier croupier) {
        sUsuario.agregarCroupier(croupier);
    }
    public void agregarJugador(Jugador jugador) {
        sUsuario.agregarJugador(jugador);
    }

    public void logout(Usuario u) {
        sUsuario.logout(u);
    } 
    public ArrayList<Mesa> getMesasHabilitadas(){
        return sUsuario.getMesasHabilitadas();
    }    
    
}
