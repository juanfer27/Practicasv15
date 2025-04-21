package com.mycompany.seccion2ejercicio2;

/**
 *
 * @author JUAN
 */
public class Seccion2ejercicio2 {

    public static void main(String[] args) {
     //Imprime un mensaje ne consola con hola bienvenido
        System.out.println("Hola bienvenido!");
        
     // Crear un objeto Cliente con valores de prueba
        Cliente cliente1 = new Cliente("Juan Fernando", 25);
        
     // Muestra la información del cliente usando el método mostrarInformacion()
        cliente1.mostrarInformacion();
    }
}
