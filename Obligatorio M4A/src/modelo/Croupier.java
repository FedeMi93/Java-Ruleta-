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
public class Croupier extends Usuario{
     
    private Mesa mesa;   

    public Mesa getMesa() {
        return mesa;
    }
    
    

    public Croupier(int cedula, String password, String nombreCompleto) {
        super(cedula, password, nombreCompleto);
        this.mesa = new Mesa();
    }
    
    
    public void logout(){
        this.setEstaActivo(false);
    }
    public void iniciarMesa(ArrayList<TipoApuesta> tiposApuesta){
        this.mesa.iniciar(tiposApuesta);
    }
    
    
}
