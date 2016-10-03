package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;
import model.UserHashMap;

/**
 * Created by kruby on 10/2/16.
 */
public class ProfileScreenController {

    @FXML
    private Button editButton;
    @FXML
    private Button backButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label addressLabel;

    private String NAString = "Not set";

    /**
     * Initializes the label values to user data.
     */
    @FXML
    private void initialize() {
        displayProfile();
    }

    /**
     * Called when the back button is clicked, goes back to the application screen.
     */
    @FXML
    private void backClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * the user's profile data.
     */
    @FXML
    private void editClicked() {
        try {
            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("/view/ProfileEditDialog.fxml"));
            Parent root1 = (Parent) fxmlloader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner( (Stage) editButton.getScene().getWindow());
            Scene scene = new Scene(root1);
            dialogStage.setScene(scene);
            ProfileEditDialogController controller = fxmlloader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            displayProfile();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update the labels to display appropriate user data.
     */
    public void displayProfile() {
        User currentUser = UserHashMap.soleInstance.getCurrentUser();
        if (currentUser == null) {
            usernameLabel.setText(NAString);
            titleLabel.setText(NAString);
            emailLabel.setText(NAString);
            addressLabel.setText(NAString);
        } else {
            usernameLabel.setText(currentUser.getName() == null ? NAString : currentUser.getName());
            titleLabel.setText(currentUser.getTitle() == null ? NAString : currentUser.getTitle());
            emailLabel.setText(currentUser.getEmail() == null ? NAString : currentUser.getEmail());
            addressLabel.setText(currentUser.getHomeAddress() == null ? NAString : currentUser.getHomeAddress());
        }
    }
}
