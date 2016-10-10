package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

import java.awt.*;

/**
 * Controller for welcome screen that allows user to enter login screen
 */

public class WelcomeScreenController {

    @FXML
    public Button registerButton;

    @FXML
    public void loginClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) registerButton.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void registerClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/RegistrationScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) registerButton.getScene().getWindow();
            stage1.close();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
