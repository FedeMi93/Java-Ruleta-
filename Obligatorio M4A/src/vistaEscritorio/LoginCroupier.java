/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistaEscritorio;



import controlador.ControladorLoginCroupier;
import java.awt.Frame;
import modelo.Croupier;



public class LoginCroupier extends Login{

    public LoginCroupier(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN CROUPIER");
        setControlador(new ControladorLoginCroupier(this));
    }

    @Override
    public void proximoCasoUso(Object u) {
        dispose();
        new IniciarMesa(null,false,(Croupier)u).setVisible(true);
    }
    
}
