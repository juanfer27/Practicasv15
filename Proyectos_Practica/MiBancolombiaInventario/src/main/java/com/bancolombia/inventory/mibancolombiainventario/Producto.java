/*
  Clase que representa un producto dentro del sistema de inventario
  Contiene atributos esenciales como ID, nombre, precio y cantidad
  Proporciona métodos getter y setter para la manipulación de los datos
 
  Autor: JUAN
 */

package com.bancolombia.inventory.mibancolombiainventario;

public class Producto {

    // Atributos del producto
    private int id;          // Identificador unico del producto
    private String nombre;   // Nombre del producto
    private double precio;   // Precio unitario del producto
    private int cantidad;    // Cantidad disponible en stock

    /*
      Constructor de la clase Producto
      Inicializa los atributos con los valores proporcionados 
     */
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /*
      Metodos getters y setters
      get obtiene el valor actual del campo
      set asigna un nuevo valor al campo
     */
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

