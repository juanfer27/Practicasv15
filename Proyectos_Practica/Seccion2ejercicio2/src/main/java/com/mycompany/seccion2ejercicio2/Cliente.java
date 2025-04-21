/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seccion2ejercicio2;

/**
 *
 * @author JUAN
 */

public class Cliente {
    /*Declaramos las variables, si bien "final" no es obligatorio esto
    nos permite evitar errores de modificaciones no intencionales
    */
    private final String nombre;
    private final int edad;

    // Creamos el constructor para Cliente 
    public Cliente(String nombre, int edad) {
        // Usamos this.nombre para referirnos al atributo del objeto
        // y le asignamos el valor del parámetro recibido
        this.nombre = nombre;
        this.edad = edad;
    }
    // Método que muestra la información del cliente en consola
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + ", Edad: " + edad);
    }
}




