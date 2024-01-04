/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.RuletaException;

/**
 *
 * @author feder
 */
public class ControladorLoginJugador extends ControladorLogin{

    public ControladorLoginJugador(VistaLogin vista) {
        super(vista);
    }    
    

    @Override
    public Object llamarLoginModelo(int cedula, String pwd) throws RuletaException {
        return Fachada.getInstancia().loginJugador(cedula, pwd);
    }
    
}
