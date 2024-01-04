/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import modelo.Fachada;
import modelo.RuletaException;
import vistaEscritorio.Login;

/**
 *
 * @author PC
 */
public abstract class ControladorLogin {
    
    private VistaLogin vista;

    public ControladorLogin(VistaLogin vista) {
        this.vista = vista;
    }
    
    public void login(int cedula,String pwd){
        try{
            Object o = llamarLoginModelo(cedula,pwd);
            if(o == null) {
                vista.error("No hubo coincidencias con la cedula ingresada.");
            } else vista.proximoCasoUso(o);
        }catch (RuletaException re){
            vista.error(re.getMessage());
        } 
        
        
    }

    public abstract Object llamarLoginModelo(int cedula, String pwd)throws RuletaException;
        
    
}
