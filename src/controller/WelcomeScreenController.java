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
    private MainFXApplication mainApplication;

    @FXML
    public Button registerButton;

    @FXML
    public void loginClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void registerClicked() {
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Feature is Unimplemented");
            alert.setContentText("This feature is currently unimplemented, sorry for the inconvenience!" +
                                 " Please contact the developers for more information.");

            alert.showAndWait();

            //Test code to launch application screen
            /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

            ((Stage) registerButton.getScene().getWindow()).close();*/
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
