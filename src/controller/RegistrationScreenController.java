package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;
import model.UserHashMap;
import model.UserType;

import java.util.Arrays;


/**
 * Controller for login screen
 */
public class RegistrationScreenController {
    private MainFXApplication mainFXApplication;

    @FXML
    private Button backButton;

    @FXML
    private Button registerButton;

    @FXML
    public Label labelCaps;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private ChoiceBox<UserType> typeChoiceBox;

    @FXML
    private void initialize() {
        typeChoiceBox.getItems().setAll(UserType.values());
    }


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

    public void registerClicked() {
        User newUser = new User(usernameField.getText(), passwordField.getText(), nameField.getText(), typeChoiceBox.getValue());
        UserHashMap.soleInstance.add(newUser);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/LoginScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = (Stage) backButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
