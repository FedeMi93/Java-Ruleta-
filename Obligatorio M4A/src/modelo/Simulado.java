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
public class Simulado extends Efecto{

    public Simulado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esNumeroValido(int n, Mesa m) {
        ArrayList<Apuesta> apuestas = m.getRondaActual().getApuestas();
        boolean esValido = false;
        if(n == 0)return true;
        for(Apuesta a: apuestas){
            if(a.getElCasillero().getUcc() == n)esValido = true;
        }
        return esValido;
    }
    
}
