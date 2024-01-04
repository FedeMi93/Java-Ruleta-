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
public class Casillero {
    private int ucc;    
    private TipoApuesta tipoApuesta;
    private ArrayList<Integer> numeros; 
    private ArrayList<Apuesta> apuestas;

    Casillero( ArrayList<Integer> numeros, int ucc, TipoApuesta tpa) {        
        this.numeros = numeros;
        this.ucc = ucc;
        this.tipoApuesta = tpa;
        this.apuestas = new ArrayList();
    }

    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public int getUcc() {
        return ucc;
    }
    
    public int getTotalApostado(){
        int total = 0;
        for(Apuesta a: apuestas){
            total+=a.getValor();
        }
        return total;
    }

    public boolean esGanador(int numeroGanador) {
       boolean esGanador = false;
        for(int n: numeros){
            if(n == numeroGanador)esGanador = true;
        }
        return esGanador;
    }

    public double saldoAPagar(int numeroGanador) {
        double saldo = 0;
        if(esGanador(numeroGanador)){
            for(Apuesta a: apuestas){
                saldo += a.pagar(tipoApuesta.getFactorDePago());// aca hay un error
            }
        }
            
        return saldo;    
    }

    void agregarApuesta(Apuesta a) {
        apuestas.add(a);
    }

    public double getFactorDePago() {
        return tipoApuesta.getFactorDePago();
    }

    boolean aplicaRestriccion(Apuesta a, Mesa laMesa) {
        return tipoApuesta.aplicaRestriccion(a, laMesa);
    }
    
}
