/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.m4a;

import modelo.*;


/**
 *
 * @author feder
 */
public class Precarga {
    public static void cargar(){
        
        Fachada logica = Fachada.getInstancia();
        
        logica.agregarTipoApuesta(new Color("Colores"));        
        logica.agregarTipoApuesta(new Docena("Docenas"));        
        logica.agregarTipoApuesta(new Directa("Directas"));
        
        logica.agregarEfecto(new Completo("Completo"));
        logica.agregarEfecto(new Parcial("Parcial"));
        logica.agregarEfecto(new Simulado("Simulado"));
        
        logica.agregarCroupier(new Croupier(101, "aaa", "Anna Anderson"));
        logica.agregarCroupier(new Croupier(102, "bbb", "Benjamin Baker"));
        logica.agregarCroupier(new Croupier(103, "ccc","Catherine Clark"));
        
        logica.agregarJugador(new Jugador(201,"aaa", 1000, "Ana Allen"));
        logica.agregarJugador(new Jugador(202,"bbb", 500, "Bruce Banner"));
        logica.agregarJugador(new Jugador(203,"ccc", 100, "Wade Wilson"));
        logica.agregarJugador(new Jugador(204,"ddd", 50, "Scott Summers"));
        logica.agregarJugador(new Jugador(205,"eee", 10, "Reed Richards"));

    }
}
