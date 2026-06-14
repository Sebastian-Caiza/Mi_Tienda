package com.example.mitienda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private ComboBox<String> cmbCategoria;
    @FXML private ComboBox<String> cmbEstado;
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colCodigo;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colCategoria;
    @FXML private TableColumn<Producto, String> colPrecio;
    @FXML private TableColumn<Producto, String> colStock;
    @FXML private TableColumn<Producto, String> colEstado;

    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cmbCategoria.getItems().addAll("Calzado", "Ropa", "Accesorios");
        cmbEstado.getItems().addAll("Activo", "Inactivo");

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaProductos.setItems(listaProductos);

        tablaProductos.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        txtCodigo.setText(newVal.getCodigo());
                        txtNombre.setText(newVal.getNombre());
                        cmbCategoria.setValue(newVal.getCategoria());
                        txtPrecio.setText(newVal.getPrecio());
                        txtStock.setText(newVal.getStock());
                        cmbEstado.setValue(newVal.getEstado());
                    }
                }
        );
    }

    @FXML
    private void btnNuevo() {
        limpiarCampos();
    }

    @FXML
    private void btnGuardar() {
        if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Código y Nombre son obligatorios");
            alert.show();
            return;
        }
        Producto p = new Producto(
                txtCodigo.getText(),
                txtNombre.getText(),
                cmbCategoria.getValue(),
                txtPrecio.getText(),
                txtStock.getText(),
                cmbEstado.getValue()
        );
        listaProductos.add(p);
        limpiarCampos();
    }

    @FXML
    private void btnActualizar() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Selecciona un producto de la tabla");
            alert.show();
            return;
        }
        seleccionado.setCodigo(txtCodigo.getText());
        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setCategoria(cmbCategoria.getValue());
        seleccionado.setPrecio(txtPrecio.getText());
        seleccionado.setStock(txtStock.getText());
        seleccionado.setEstado(cmbEstado.getValue());
        tablaProductos.refresh();
        limpiarCampos();
    }

    @FXML
    private void btnEliminar() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Selecciona un producto de la tabla");
            alert.show();
            return;
        }
        listaProductos.remove(seleccionado);
        limpiarCampos();
    }

    @FXML
    private void btnLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
        cmbCategoria.setValue(null);
        cmbEstado.setValue(null);
        tablaProductos.getSelectionModel().clearSelection();
    }
}