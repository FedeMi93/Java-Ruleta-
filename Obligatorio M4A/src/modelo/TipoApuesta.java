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
public abstract class TipoApuesta {
    private double factorDePago;
    private String nombre;
    private boolean obligatorio;    
    
    public double getFactorDePago() {
        return factorDePago;
    }    

    public String getNombre() {
        return nombre;
    }    

    public boolean isObligatorio() {
        return obligatorio;
    }   
    


    public TipoApuesta(double factorDePago, String nombre, boolean obligatorio) {
        this.factorDePago = factorDePago;
        this.nombre = nombre;
        this.obligatorio = obligatorio;    
                        
    }
    
    public abstract boolean aplicaRestriccion(Apuesta a, Mesa m); 
    public abstract ArrayList<Casillero> crearCasilleros();
    
}
