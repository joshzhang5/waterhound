package controller;

import fxapp.MainFXApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.awt.event.KeyEvent;
import javafx.scene.input.KeyCode;
import java.awt.Toolkit;


/**
 * Controller for login screen
 */
public class LoginScreenController {
    private MainFXApplication mainFXApplication;

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    public Label labelCaps;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private final String user = "water";
    private final String pass = "hound";
    private static int loginAttempts = 0;


    public void backClicked() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/WelcomeScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = (Stage) backButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void loginClicked() {
        if (usernameField.getText().equals("water") && passwordField.getText().equals("hound")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
        if (!usernameField.getText().equals("water") && !passwordField.getText().equals("hound")){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Login Failed");
            alert.setContentText("Try retyping username and password");
            loginAttempts++;
            alert.showAndWait();
        }
    }

}
