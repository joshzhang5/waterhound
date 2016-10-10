package controller;

/**
 * Created by wshel on 10/3/2016.
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.user.User;
import model.user.UserHashMap;


public class ProfileEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;


    private Stage dialogStage;
    private User user;

    /**
     * Gets the current user and initializes values for text fields.
     */
    @FXML
    private void initialize() {
        user = UserHashMap.soleInstance.getCurrentUser();
        nameField.setText(user.getName() == null ? "" : user.getName());
        titleField.setText(user.getTitle() == null ? "" : user.getTitle());
        emailField.setText(user.getEmail() == null ? "" : user.getEmail());
        addressField.setText(user.getHomeAddress() == null ? "" : user.getHomeAddress());
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Called when the user clicks confirm, sets user data to entered values and closes dialog.
     */
    @FXML
    private void confirmClicked() {
        user.setName(nameField.getText());
        user.setTitle(titleField.getText());
        user.setEmail(emailField.getText());
        user.setHomeAddress(addressField.getText());
        dialogStage.close();
    }

    /**
     * Called when the user clicks cancel, closes the dialog.
     */
    @FXML
    private void cancelClicked() {
        dialogStage.close();
    }
}
