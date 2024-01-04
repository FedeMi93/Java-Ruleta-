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
public class Jugador extends Usuario{
    
    private double Saldo;
    private ArrayList<Mesa> mesasActivas;
    
    public void agregarMesa(Mesa m){
        if(!mesasActivas.contains(m)){
            mesasActivas.add(m);
        }
    }
    public void quitarMesa(Mesa m){
        if(!mesasActivas.contains(m)){
            mesasActivas.remove(m);
        }
    }

    public Jugador(int cedula, String password, double Saldo, String nombreCompleto) {
        super(cedula, password, nombreCompleto);
        this.Saldo = Saldo;
        this.mesasActivas = new ArrayList();
    }   

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    void agregarSaldo(double valorPago) {
        Saldo += valorPago;
        for(Mesa m: mesasActivas){
            m.avisar(Mesa.eventos.pagoRonda);
        }
    }

    void restarApuesta(int ficha) {
        Saldo -= ficha;
        for(Mesa m: mesasActivas){
            m.avisar(Mesa.eventos.actualizarSaldo);
        }
    }
    
    
    
}
