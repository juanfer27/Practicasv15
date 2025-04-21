
package com.mycompany.seccion2ejercicio1;

/**
 *
 * @author JUAN
 */
public class Producto {
    
  //debemos declarar las variables 
    private int id;              //Identificador único del producto 
    private String nombre;       //Nombre del producto
    private double precio;       //Precio por unidad del producto
    private int cantidadEnStock; //Cantidad disponible en stock del prodcuto
    
  //generamos el constructor, este inicializa todos los atributos dle producto 
    public Producto(int id, String nombre, double precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }
    
  /*generamos los getters and setters
   Métodos getter: devuelven los valores de los atributos  
   Métodos setter: permiten modificar los valores de los atributos*/ 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
    
  /*ahora calcularemos el valor total del stock del producto
    para esto debemos saber que total de stock es la multiplicacion de 
    la cantidad del stock por su valor 
  */
 // Método que calcula el valor total del stock del producto
    public double calcularValorStock() {
        return precio * cantidadEnStock;
    }
    
}
