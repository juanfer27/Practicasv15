 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seccion3ejercicio1;

import java.util.Arrays;

/**
 *
 * @author JUAN
 */
public class Seccion3Ejercicio1 {

    public static void main(String[] args) {
       

        // Lista de números de ejemplo
        //int[] lista = {4, 1, 7, 3, 9};
        //int[] lista = {8, 1, 12, 3, 10};
        int[] lista = {2, 5, 3, 11, 8};
        // Validación básica: si hay menos de 2 elementos, mostramos un mensaje y terminamos
        if (lista.length < 2) {
            System.out.println("La lista debe tener al menos dos elementos.");
            return; // Finaliza el programa sin hacer nada más
        }

        // Inicializamos las variables con el valor más bajo posible
        int mayor = Integer.MIN_VALUE;
        int segundo = Integer.MIN_VALUE;

        // Recorremos la lista para encontrar el mayor y el segundo mayor
        for (int n : lista) {
            if (n > mayor) {
                segundo = mayor; // El anterior mayor pasa a ser el segundo
                mayor = n;        // El nuevo mayor se actualiza
            } else if (n > segundo && n != mayor) {
                segundo = n;      // Solo actualiza si es distinto al mayor y más grande que el segundo
            }
        }

        // Mostramos los resultados
        System.out.println("Lista: " + Arrays.toString(lista));
        System.out.println("Segundo numero mas grande: " + segundo);

   
    }
}
