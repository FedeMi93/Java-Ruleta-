/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author feder
 */
public class Directa extends TipoApuesta{

    public Directa(String nombre) {
        super(36, nombre, true);
    }

    @Override
    public boolean aplicaRestriccion(Apuesta a, Mesa m) {
        return false;
    }

    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList();
        for(int i = 0; i<= 36; i++){
            ArrayList<Integer> numeros = new ArrayList<>(List.of(i));
            Casillero c = new Casillero(numeros, i, this);
            casilleros.add(c);
        }
        return casilleros;
    }
    
}
