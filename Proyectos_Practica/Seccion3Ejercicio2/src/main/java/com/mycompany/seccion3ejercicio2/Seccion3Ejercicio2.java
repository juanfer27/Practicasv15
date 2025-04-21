/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seccion3ejercicio2;

import static com.mycompany.seccion3ejercicio2.ReservaCine.puedeReservar;

/**
 *
 * @author JUAN
 */
public class Seccion3Ejercicio2 {

    public static void main(String[] args) {
        
        System.out.println("Bienvenido a CineColombia!");
        
         // Primer caso de prueba (sí se puede reservar)
        int[][] sala1 = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        // Segundo caso de prueba (no se puede reservar)
        int[][] sala2 = {
            {1, 1, 1, 1},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        // Tercer caso de prueba (una fila vacia completamente)
        int[][] sala3 = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };
        
        // Cuarto caso de prueba (toda libre)
        int[][] sala4 = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        
        // Quinto caso de prueba (centro libre)
        int[][] sala5 = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };
        
        
          // Quinto caso de prueba (ocupacion parcial)
        int[][] sala6 = {
            {1, 0, 1, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1}
        };
        
        
        System.out.println("Sala 1: " + puedeReservar(sala1)); // true
        System.out.println("Sala 2: " + puedeReservar(sala2)); // false
        System.out.println("Sala 3: " + puedeReservar(sala3)); // true
        System.out.println("Sala 4: " + puedeReservar(sala4)); // true
        System.out.println("Sala 5: " + puedeReservar(sala5)); // true
        System.out.println("Sala 5: " + puedeReservar(sala6)); // false
    }
}
