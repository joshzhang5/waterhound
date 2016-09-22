package controller;

import fxapp.MainFXApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller for login screen
 */
public class LoginScreenController {
    private MainFXApplication mainFXApplication;
    @FXML
    public Button backButton;
    @FXML
    public void backClicked() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
