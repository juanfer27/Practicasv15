package com.bancolombia.inventory.mibancolombiainventario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/*
 Clase principal que inicia la aplicación JavaFX.
 Carga la interfaz desde el archivo FXML y configura la ventana principal.
 
 Autor: JUAN
 */
public class App extends Application {

    // Escena principal de la aplicación
    private static Scene scene;

    /*
      Método que se ejecuta al iniciar la aplicación.
      Se carga el archivo FXML principal y se muestra la ventana.
      @param stage Ventana primaria del sistema
      @throws IOException si no se encuentra el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Cargar la escena desde el archivo primary.fxml
        scene = new Scene(loadFXML("primary"), 800, 600); // Dimensiones 

        // Título de la ventana principal
        stage.setTitle("Mi Bancolombia Inventario");

        // Asignar la escena al escenario y mostrarla
        stage.setScene(scene);
        stage.show();
    }

    /*
     Permite cambiar dinámicamente la raíz de la escena.
     Útil si se desea navegar entre diferentes vistas (FXML).
    
      fxml Nombre del archivo FXML a cargar (sin extensión)
     @throws IOException si el archivo no se puede cargar
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /*
     Carga y retorna un archivo FXML como nodo raíz (Parent).
     @param fxml Nombre del archivo FXML a cargar
     @return Nodo raíz de la vista
     @throws IOException si ocurre un error al cargar el archivo
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /*
     Método principal que lanza la aplicación.
   
     */
    public static void main(String[] args) {
        launch(); // Lanza el ciclo de vida de la aplicación JavaFX
    }
}

