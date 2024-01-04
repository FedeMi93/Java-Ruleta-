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
public class Color extends TipoApuesta{
    
    private ArrayList<Integer> rojos = new ArrayList<>(List.of(1, 3, 5,7, 9,12,14,16,18,19,21,23,25,27,30,32,34,36));
    private ArrayList<Integer> negros = new ArrayList<>(List.of(2, 4, 6, 8, 10,11,13,15,17,20,22,24,26,28,29,31,33,35));
    
    

    public Color(String nombre) {
        super(2, nombre, false);       
    }

    @Override
    public boolean aplicaRestriccion(Apuesta a, Mesa m) {
        boolean aplica = false;
        int apostoAColor = 0;
        if(m.getUltimaRonda() == null)return false;
        for(Apuesta ap: m.getUltimaRonda().getApuestas()){
            if(a.getJugador() == ap.getJugador() && a.getElCasillero().getUcc() == ap.getElCasillero().getUcc() && a.getValor() > ap.getValor()){
                aplica = true;
            }
            if(a.getJugador() == ap.getJugador() && ap.getElCasillero().getUcc() == 43) apostoAColor++;
            if(a.getJugador() == ap.getJugador() && ap.getElCasillero().getUcc() == 44) apostoAColor++;            
        }
        if(apostoAColor == 2 && m.getUltimaRonda().getNumeroGanador() != 0)aplica = false;
        return aplica;
    }

    @Override
    public ArrayList<Casillero> crearCasilleros() {
        ArrayList<Casillero> casilleros = new ArrayList();
        
        Casillero c = new Casillero(this.negros, 44, this);
        casilleros.add(c);
        
        Casillero c2 = new Casillero(this.rojos, 43, this);
        casilleros.add(c2);
        
        return casilleros;        
    }
    
}
