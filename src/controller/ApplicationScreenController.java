package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for temporary application screen
 * Currently just has logout that returns user back to welcome screen
 */
public class ApplicationScreenController {
    @FXML
    private Button logoutButton;

    @FXML
    private void initialize() {
    }

    /**
     * Loads window screen when logout button is pressed
     * @throws IOException if fxml file is not found
     */
    @FXML
    private void goToWelcomeScreen() throws IOException{
        //Gets stage by looking at which window the button is in.
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("../view/WelcomeScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
