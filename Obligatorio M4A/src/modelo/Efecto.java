/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author feder
 */
public abstract class Efecto {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Efecto(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract boolean esNumeroValido(int n, Mesa m);

    @Override
    public String toString() {
        return  this.nombre;
    }
    
}
