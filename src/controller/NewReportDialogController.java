package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.report.ReportList;
import model.report.WaterCondition;
import model.report.WaterSourceReport;
import model.report.WaterType;
import model.user.User;
import model.user.UserHashMap;


public class NewReportDialogController {

    @FXML
    private TextField locationField;
    @FXML
    private ChoiceBox<WaterType> waterTypeChoiceBox;
    @FXML
    private ChoiceBox<WaterCondition> waterConditionChoiceBox;


    private Stage dialogStage;
    private User user;

    /**
     * Gets the current user and initializes values for text fields.
     */
    @FXML
    private void initialize() {
        waterTypeChoiceBox.getItems().setAll(WaterType.values());
        waterConditionChoiceBox.getItems().setAll(WaterCondition.values());
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
     * Called when the user clicks confirm, creates new report based on entered data and closes dialog.
     */
    @FXML
    private void confirmClicked() {
        if (locationField.getText() == null || waterTypeChoiceBox.getValue() == null || waterConditionChoiceBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Report Creation Failed");
            alert.setHeaderText("Report Creation Failed");
            alert.setContentText("No fields can be left empty");
            alert.showAndWait();
            return;
        }

        WaterSourceReport report = new WaterSourceReport(locationField.getText(), waterTypeChoiceBox.getValue(),
                waterConditionChoiceBox.getValue());

        ReportList.soleInstance.add(report);

        //Test remove later
        report.getOutput();

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
