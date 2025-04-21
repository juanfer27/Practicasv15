/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seccion2ejercicio1;

/**
 *
 * @author JUAN
 */
public class Seccion2Ejercicio1 {

    public static void main(String[] args) {
        
        //muestra un mensaje de bienvenida
        System.out.println("Bienvenido!");
        
        // Crear un objeto Producto con datos de ejemplo
        Producto producto1 = new Producto(1, "Teclado mecanico", 65000.0, 11);
        
         // Mostrar la información del producto en consola
        System.out.println("Producto: " + producto1.getNombre());
        System.out.println("Precio: $" + producto1.getPrecio());
        System.out.println("Cantidad en stock: " + producto1.getCantidadEnStock());
        
        // Calcular y mostrar el valor total del stock
        System.out.println("Valor total del stock: $" 
        +producto1.calcularValorStock());
        
    }
}
