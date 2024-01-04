/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Casillero;
import modelo.Efecto;
import modelo.Jugador;
import modelo.Ronda;

/**
 *
 * @author feder
 */
public interface VistaOperarMesa {
    public void cargarEfectos(ArrayList<Efecto> efectos);
    public void cargarNumRuleta(int num);
    
    public void actualizarBalance(double Balance);

    public void actualizarRonda(int numRonda);
    
    public void actualizarUltimosNumeros(ArrayList<Integer> sorteados);

    public void actualizarJugadores(ArrayList<Jugador> jugadores);
    public void actualizarTablaRondas(ArrayList<String> datos);
    public void actualizarRondaActual(int apuestas, double monto);

    public void actualizarUltimoNumero(int numeroGanador);

    public void mostrarApuestas(ArrayList<Casillero> casilleros);
    public void mostrarOcultarCasilleros(ArrayList<Casillero> casilleros);
    
}
