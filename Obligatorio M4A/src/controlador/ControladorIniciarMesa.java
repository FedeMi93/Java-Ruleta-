/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Croupier;
import modelo.Fachada;
import modelo.TipoApuesta;

/**
 *
 * @author feder
 */
public class ControladorIniciarMesa {
    private VistaIniciarMesa vista;
    private Croupier elCroupier;
    
    public ControladorIniciarMesa(VistaIniciarMesa vista, Croupier c){
        this.vista = vista;
        this.elCroupier = c;
        mostrarTiposApuesta();
    }

    public Croupier getElCroupier() {
        return elCroupier;
    }
    

    private void mostrarTiposApuesta() {
        vista.mostrarTiposApuesta(Fachada.getInstancia().getTiposDeApuesta());
    }
    public void IniciarMesa(ArrayList<TipoApuesta> tp){
        
        elCroupier.iniciarMesa(tp);
    }

    public void logout() {
        Fachada.getInstancia().logout(elCroupier);
    }
}
