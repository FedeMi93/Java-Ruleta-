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
public class Docena extends TipoApuesta{
    
    
    public Docena( String nombre) {
        super(3, nombre, false);
    }

    @Override
    public boolean aplicaRestriccion(Apuesta a, Mesa m) {
        boolean aplica = false;
        for(Apuesta ap: m.getRondaActual().getApuestas()){
            if(ap.getJugador() == a.getJugador()){
                int ucc = ap.getElCasillero().getUcc();
                if(ucc == 40 || ucc == 41 || ucc == 42){
                    aplica = true;
                }
            }
        }
        return aplica;
    }

    @Override
    public ArrayList<Casillero> crearCasilleros() {
       ArrayList<Casillero> casilleros = new ArrayList();
       
       ArrayList<Integer> primera = new ArrayList();
       ArrayList<Integer> segunda = new ArrayList();
       ArrayList<Integer> tercera = new ArrayList();
       for(int i = 1; i<=36; i++){
           if(i<=12){
               primera.add(i);
           }else if(i<=24){
               segunda.add(i);
           } else tercera.add(i);
       }
       
       Casillero c = new Casillero(primera, 40, this);
       Casillero c1 = new Casillero(segunda, 41, this);
       Casillero c2 = new Casillero(tercera, 42, this);
       casilleros.add(c);
       casilleros.add(c1);
       casilleros.add(c2);
       
       return casilleros;
    }
    
}
