package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.user.UserHashMap;

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
    @FXML
    private Button submitReportButton;
    @FXML
    private Button viewReportsButton;


    /**
     * Called when the logout button is clicked, resets current user and goes back to welcome screen.
     */
    public void logoutClicked() {
        try {
            UserHashMap.soleInstance.setCurrentUser(null);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/WelcomeScreen.fxml"));
            Parent root1 = fxmlLoader.load();
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
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) profileButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when submit report button is clicked, opens new report dialog
     */
    @FXML
    public void submitReportClicked() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("/view/NewReportDialog.fxml"));
            Parent root1 = fxmlloader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Report");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(submitReportButton.getScene().getWindow());
            Scene scene = new Scene(root1);
            dialogStage.setScene(scene);
            NewReportDialogController controller = fxmlloader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Called when the view reports button is clicked, goes to the view reports screen
     */
    @FXML
    public void viewReportsClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ViewReportsScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) viewReportsButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

