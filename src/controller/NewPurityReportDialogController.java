package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.report.*;
import model.user.User;


public class NewPurityReportDialogController {

    @FXML
    private TextField lattitudeField;
    @FXML
    private TextField longitudeField;
    @FXML
    private ChoiceBox<GeneralCondition> waterCondChoiceBox;
    @FXML
    private TextField virusPPMEntry;
    @FXML
    private TextField contPPMEntry;


    private Stage dialogStage;
    private User user;

    /**
     * Gets the current user and initializes values for text fields.
     */
    @FXML
    private void initialize() {
        waterCondChoiceBox.getItems().setAll(GeneralCondition.values());
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
        if (lattitudeField.getText() == null || longitudeField.getText() == null || waterCondChoiceBox.getValue() == null ||
                virusPPMEntry.getText() == null || contPPMEntry.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Report Creation Failed");
            alert.setHeaderText("Report Creation Failed");
            alert.setContentText("No fields can be left empty");
            alert.showAndWait();
            return;
        }

        double latitude;
        double longitude;
        double virus;
        double cont;

        //Convert text field entries to doubles
        try {
            latitude = Double.parseDouble(lattitudeField.getText());
            longitude = Double.parseDouble(longitudeField.getText());
            virus = Double.parseDouble(virusPPMEntry.getText());
            cont = Double.parseDouble(contPPMEntry.getText());
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Latitude, Longitude, or PPM");
            alert.setHeaderText("Report Creation Failed");
            alert.setContentText("Please enter a numeric value");
            alert.showAndWait();
            return;
        }

        if (!isLatLongValid(latitude, longitude)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Latitude or Longitude");
            alert.setHeaderText("Report Creation Failed");
            alert.setContentText("Latitude must be between -90 and 90. Longitude must be between -180 and 180");
            alert.showAndWait();
            return;
        }

        //LatLong center = new LatLong(33.7756, -84.3963);

        PurityReport report = new PurityReport(latitude, longitude, waterCondChoiceBox.getValue(), virus, cont);

        PurityReportList.soleInstance.add(report);

        dialogStage.close();
    }

    /**
     * Called when the user clicks cancel, closes the dialog.
     */
    @FXML
    private void cancelClicked() {
        dialogStage.close();
    }

    /**
     * Helper method that checks if latitude and longitude are within appropriate boundaries
     */
    private boolean isLatLongValid(double lat, double lon) {
        return Math.abs(lat) <= 90 || Math.abs(lon) <= 180;
    }
}
