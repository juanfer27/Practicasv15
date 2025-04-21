/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seccion3ejercicio2;

/**
 *
 * @author JUAN
 */
public class ReservaCine {
    
    /*
    Debemos crear una matriz, recorrrerla para finalmente validar.
    */
    
    //creamos un metodo con nobre puede resaervar y le damos una matriz
    public static boolean puedeReservar(int[][] sala) {
        // Recorremos cada fila de la sala
        for (int[] sala1 : sala) {
            // Recorremos cada columna de la fila, hasta la penúltima
            for (int j = 0; j < sala1.length - 1; j++) {
                // Verificamos si hay dos asientos libres seguidos
                if (sala1[j] == 0 && sala1[j + 1] == 0) {
                    return true; // Hay disponibilidad para reservar
                }
            }
        }
        return false; // No se encontró ninguna fila con dos asientos libres juntos
    }

    
}