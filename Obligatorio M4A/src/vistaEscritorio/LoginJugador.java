/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;

import controlador.ControladorLoginJugador;
import java.awt.Frame;
import modelo.Jugador;



public class LoginJugador extends Login{

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN JUGADOR");
        setControlador(new ControladorLoginJugador(this));
    }

    @Override
    public void proximoCasoUso(Object u) {
        dispose();
        new ElegirMesa(null, false, (Jugador)u).setVisible(true);
    }
    
}
