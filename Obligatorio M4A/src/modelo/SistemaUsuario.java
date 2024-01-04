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
public class SistemaUsuario {
    
    private ArrayList<Croupier> croupiers = new ArrayList();
    private ArrayList<Jugador> jugadores = new ArrayList();
    
    private Usuario buscarUsuario(int cedula, String password, ArrayList al)throws RuletaException{
        Usuario u;
        for(Object o: al){
            u = (Usuario)o;
            if(u.getCedula() == cedula){
                if(!u.getPassword().equals(password)){
                    throw new RuletaException("Credenciales incorrectas.");                    
                } else if(u.isEstaActivo()){
                    throw new RuletaException("Acceso denegado. El usuario ya tiene una sesión activa.");
                }else{
                    u.setEstaActivo(true);
                    return u;
                }
            }
        }
        return null;
    }

    public Croupier loginCrupier(int cedula, String password)throws RuletaException {        
        return (Croupier) buscarUsuario(cedula, password, croupiers);
    }
    public Jugador loginJugador(int cedula, String password)throws RuletaException {        
        return (Jugador) buscarUsuario(cedula, password, jugadores);
    }
    

    void agregarCroupier(Croupier croupier) {        
       if(!croupiers.contains(croupier))croupiers.add(croupier);       
    }
    public void agregarJugador(Jugador j){
        if(!jugadores.contains(j))jugadores.add(j);
    }
    public void logout(Usuario u){
        u.setEstaActivo(false);
    }

    public ArrayList<Mesa> getMesasHabilitadas() {
        ArrayList<Mesa> mesas = new ArrayList(); 
        for(Croupier c: croupiers){
            if(c.getMesa().isEstaActiva())mesas.add(c.getMesa());
        }
        return mesas;
    }
    
}
