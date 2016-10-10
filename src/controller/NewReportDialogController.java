package controller;


import javafx.fxml.FXML;
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
