/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Apuesta;

/**
 *
 * @author feder
 */
public interface VistaJugarMesa {
    public void error(String msg);

    public void cargarNombreCompleto(String nombreCompleto);

    public void actualizarSaldo(double saldo);

    public void actualizarMesaRonda(int numMesa, int numeroRonda);
    public void mostrarApuestas(ArrayList<Apuesta> apuestas);
    public void mostrarValorOcurrencia(ArrayList<Integer> ocurrencia);
    public void limpiar();
    public void cerrar();

    public void mostrarEstadisticasjugador(ArrayList<String> estadisticas);

    public void cerroMesa(String el_croupier_cerro_la_mesa);
}
