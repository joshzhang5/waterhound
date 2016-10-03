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
import model.User;
import model.UserHashMap;

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
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    private static int loginAttempts = 0;


    /**
     * Called when back button is clicked, goes back to welcome screen.
     */
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

    /**
     * Called when login button is clicked, sets current user and
     * goes to application screen if credentials are correct.
     */
    public void loginClicked() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        User user = UserHashMap.soleInstance.get(enteredUsername);

        if (user != null && user.isCorrectPassword(enteredPassword)) {
            try {
                UserHashMap.soleInstance.setCurrentUser(user);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationScreen.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                Scene scene = new Scene(root1);
                stage.setScene(scene);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Login Failed");
            alert.setContentText("Try retyping username and password");
            loginAttempts++;
            alert.showAndWait();
        }

    }

}
