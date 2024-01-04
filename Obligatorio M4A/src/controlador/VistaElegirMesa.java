/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Jugador;
import modelo.Mesa;

/**
 *
 * @author feder
 */
public interface VistaElegirMesa {
     public void error(String msg);
     public void mostrarMesas(ArrayList<Mesa> mesas);
     public void proximoCasoUso(Jugador j, Mesa m);
}
