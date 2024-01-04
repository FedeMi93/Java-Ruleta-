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
public class SistemaJuego {
    private ArrayList<TipoApuesta> tiposDeApuesta = new ArrayList();
    private ArrayList<Efecto> efectos = new ArrayList();

    public ArrayList<TipoApuesta> getTiposDeApuesta() {
        return tiposDeApuesta;
    }

    public ArrayList<Efecto> getEfectos() {
        return efectos;
    }    
    
    
    public void agregarTipoApuesta(TipoApuesta t){
        tiposDeApuesta.add(t);
    }
    public void agregarEfecto (Efecto e){
        efectos.add(e);
    }
    
}
