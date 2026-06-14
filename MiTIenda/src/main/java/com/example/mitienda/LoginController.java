package com.example.mitienda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField ingresoUsuario;
    @FXML private PasswordField ingresoPassword;
    @FXML private ComboBox<String> seleccionarRol;
    @FXML private Label lblError;

    @FXML
    public void initialize() {
        seleccionarRol.getItems().addAll("Administrador", "Vendedor", "Cajero");
    }

    @FXML
    private void ingresoSesion() {
        String usuario = ingresoUsuario.getText();
        String password = ingresoPassword.getText();
        String rol = seleccionarRol.getValue();

        if (usuario.equals("admin") && password.equals("1234")
                && rol != null && rol.equals("Administrador")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ingresoUsuario.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("MiTienda - Dashboard");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            lblError.setText("Usuario, contraseña o rol incorrectos");
        }
    }
}