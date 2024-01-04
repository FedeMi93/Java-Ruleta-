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
public class Parcial extends Efecto{

    public Parcial(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esNumeroValido(int n, Mesa m) {
        boolean esValido = true;
        ArrayList<Ronda> rondas = m.getRondas();
        for(int i = rondas.size()-1; i > rondas.size()-4 && i >= 0; i--){
            if(rondas.get(i).getNumeroGanador() == n)esValido = false;
        }
        return esValido;
    }
    
}
