package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.User;
import model.UserHashMap;

/**
 * Controller for temporary application screen
 * Currently just has logout that returns user back to welcome screen
 */
public class ApplicationScreenController {
    private MainFXApplication mainApplication;

    @FXML
    private Button logoutButton;
    @FXML
    private Button profileButton;

    /**
     * Called when the logout button is clicked, resets current user and goes back to welcome screen.
     */
    public void logoutClicked() {
        try {
            UserHashMap.soleInstance.setCurrentUser(null);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/WelcomeScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the profile button is clicked, goes to the profile view screen.
     */
    @FXML
    public void profileClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ProfileScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = (Stage) profileButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

