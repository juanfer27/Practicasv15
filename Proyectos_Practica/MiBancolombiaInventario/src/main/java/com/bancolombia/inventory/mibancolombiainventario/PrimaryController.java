package com.bancolombia.inventory.mibancolombiainventario;

/**
  Controlador principal de la interfaz gráfica.
  Maneja el registro, modificación, eliminación y visualización de productos en una tabla.
  También se encarga de cargar el logo institucional.
 
  @author JUAN
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.security.GeneralSecurityException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.poifs.crypt.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;


public class PrimaryController implements Initializable {

    // Componentes de la tabla
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colCantidad;

    // Campos de entrada de datos
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtCantidad;

    // Imagen del logo institucional
    @FXML private ImageView logoImage;

    // Lista observable que contiene los productos cargados en memoria
    private final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    /*
      Método de inicialización del controlador.
      Configura la tabla, carga el logo y define la acción al hacer clic sobre un elemento de la tabla.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Cargar logo desde la carpeta /images
        Image logo = new Image(getClass().getResourceAsStream("/images/logo_mibancolombia.png"));
        logoImage.setImage(logo);

        // Configurar las columnas para que muestren las propiedades del objeto Producto
        colId.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getId()).asObject());
        colNombre.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getNombre()));
        colPrecio.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrecio()).asObject());
        colCantidad.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getCantidad()).asObject());

        // Asociar la lista de productos a la tabla
        tablaProductos.setItems(listaProductos);

        // Acción al hacer clic sobre un producto: se cargan sus datos en los campos de texto
        tablaProductos.setOnMouseClicked(event -> {
            Producto p = tablaProductos.getSelectionModel().getSelectedItem();
            if (p != null) {
                txtId.setText(String.valueOf(p.getId()));
                txtNombre.setText(p.getNombre());
                txtPrecio.setText(String.valueOf(p.getPrecio()));
                txtCantidad.setText(String.valueOf(p.getCantidad()));
            }
        });
    }

    /*
      Guarda un nuevo producto en memoria (en la lista observable)
      Valida que los datos sean correctos antes de agregarlos
     */
    @FXML
    private void guardarProducto() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            // Validación: el nombre no debe contener números
            if (nombre.matches(".*\\d.*")) {
                mostrarAlerta("Nombre inválido", "El nombre no debe contener números.");
                return;
            }

            // Validación: los valores deben ser positivos
            if (id < 0 || precio < 0 || cantidad < 0) {
                mostrarAlerta("Valor inválido", "Los valores numéricos deben ser positivos.");
                return;
            }

            // Agregar producto a la lista y limpiar campos
            listaProductos.add(new Producto(id, nombre, precio, cantidad));
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de formato", "Verifica que ID, Precio y Cantidad sean numéricos.");
        }
    }

    /*
      Modifica un producto seleccionado de la tabla con los nuevos datos ingresados
     */
    @FXML
    private void modificarProducto() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                seleccionado.setId(Integer.parseInt(txtId.getText()));
                seleccionado.setNombre(txtNombre.getText());
                seleccionado.setPrecio(Double.parseDouble(txtPrecio.getText()));
                seleccionado.setCantidad(Integer.parseInt(txtCantidad.getText()));
                tablaProductos.refresh(); // Refrescar la vista de la tabla
                limpiarCampos();
            } catch (Exception e) {
                mostrarAlerta("Error al modificar", "Verifica los datos.");
            }
        } else {
            mostrarAlerta("Selecciona un producto", "Debes seleccionar un producto de la tabla.");
        }
    }

    /*
      Elimina el producto seleccionado de la tabla y de la lista en memoria
     */
    @FXML
    private void eliminarProducto() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            limpiarCampos();
        } else {
            mostrarAlerta("Selecciona un producto", "No se ha seleccionado ningún producto.");
        }
    }

    /*
      Limpia todos los campos de entrada del formulario
     */
    @FXML
    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtCantidad.clear();
    }

    /*
      Muestra una alerta con un mensaje personalizado
      titulo   Título de la alerta
      mensaje  Contenido del mensaje
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    @FXML
    private void exportarExcel() throws InvalidFormatException, GeneralSecurityException {
        try {
            try (Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("Inventario");
                
                // Encabezado
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("ID");
                header.createCell(1).setCellValue("Nombre");
                header.createCell(2).setCellValue("Precio");
                header.createCell(3).setCellValue("Cantidad");
                
                // Cuerpo
                int rowIndex = 1;
                for (Producto p : tablaProductos.getItems()) {
                    Row row = sheet.createRow(rowIndex++);
                    row.createCell(0).setCellValue(p.getId());
                    row.createCell(1).setCellValue(p.getNombre());
                    row.createCell(2).setCellValue(p.getPrecio());
                    row.createCell(3).setCellValue(p.getCantidad());
                }
                
                try ( // Crear archivo temporal sin contraseña
                        FileOutputStream fos = new FileOutputStream("temp.xlsx")) {
                    workbook.write(fos);
                }
            }

            // Leer el archivo y aplicar encriptación
            POIFSFileSystem fs = new POIFSFileSystem();
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
            Encryptor encryptor = info.getEncryptor();
            encryptor.confirmPassword("Bancolombia2025"); // Aquí defino la contraseña

            try (OPCPackage opc = OPCPackage.open(new File("temp.xlsx"), PackageAccess.READ_WRITE); OutputStream os = encryptor.getDataStream(fs)) {
                opc.save(os);
            }

            try (FileOutputStream fosEnc = new FileOutputStream("InventarioProtegido.xlsx")) {
                fs.writeFilesystem(fosEnc);
            }

            // Borrar archivo temporal
            new File("temp.xlsx").delete();

            mostrarAlerta("Éxito", "Archivo InventarioProtegido.xlsx exportado con contraseña.");

        } catch (IOException e) {
            mostrarAlerta("Error", "Error al exportar con contraseña: " + e.getMessage());
        }
    }


    
    
    
}

