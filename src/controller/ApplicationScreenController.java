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
import model.user.UserType;

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
    private Button submitSourceReportButton;
    @FXML
    private Button submitPurityReportButton;
    @FXML
    private Button viewReportsButton;
    @FXML
    private Button mapButton;
    @FXML
    private Button viewPurityReportButton;


    @FXML
    private void initialize() {
        int userLevel = UserHashMap.soleInstance.getCurrentUser().getType().getLevel();

        submitPurityReportButton.setDisable(userLevel < UserType.WORKER.getLevel());
        viewPurityReportButton.setDisable(userLevel < UserType.WORKER.getLevel());
    }


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
     * Called when submit source report button is clicked, opens new source report dialog
     */
    @FXML
    public void submitReportClicked() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("/view/NewReportDialog.fxml"));
            Parent root1 = fxmlloader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Source Report");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(submitSourceReportButton.getScene().getWindow());
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
     * Called when submit purity report button is clicked, opens new purity report dialog
     */
    @FXML
    public void submitPurityClicked() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("/view/NewPurityReportDialog.fxml"));
            Parent root1 = fxmlloader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Purity Report");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(submitSourceReportButton.getScene().getWindow());
            Scene scene = new Scene(root1);
            dialogStage.setScene(scene);
            NewPurityReportDialogController controller = fxmlloader.getController();
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

    /**
     * Called when the view reports button is clicked, goes to the view reports screen
     */
    @FXML
    public void viewPurityReportClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ViewPurityReportsScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) viewPurityReportButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when Water Availability button is clicked, goes to map screen
     */
    @FXML
    public void mapButtonClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MapScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = (Stage) mapButton.getScene().getWindow();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

