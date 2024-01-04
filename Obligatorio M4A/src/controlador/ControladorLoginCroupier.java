/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Fachada;
import modelo.RuletaException;

/**
 *
 * @author PC
 */
public class ControladorLoginCroupier extends ControladorLogin{

    public ControladorLoginCroupier(VistaLogin vista) {
        super(vista);
    }
    @Override
    public Object llamarLoginModelo(int cedula, String pwd) throws RuletaException{
        return Fachada.getInstancia().loginCrupier(cedula, pwd);
    }
    
}
