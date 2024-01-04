/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author feder
 */
public class Apuesta {   
    
    private double valor;
    private Casillero elCasillero;
    private Jugador jugador;

    public Apuesta(double valor, Casillero elCasillero, Jugador jugador) {
        this.valor = valor;
        this.elCasillero = elCasillero;
        this.jugador = jugador;
    }

    
    public double getValor() {
        return valor;
    }

    public Casillero getElCasillero() {
        return elCasillero;
    }

    public Jugador getJugador() {
        return jugador;
    }
    

    public void setValor(double valor) {
        this.valor = valor;
    }
    public double pagar(double factorPago){
        double valorPago = valor*factorPago;
        jugador.agregarSaldo(valorPago);
        return valorPago;
        
    }
    

    
}
