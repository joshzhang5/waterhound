package controller;

import fxapp.MainFXApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.report.ReportList;
import model.report.WaterSourceReport;
import model.user.UserHashMap;

import java.time.format.DateTimeFormatter;

/**
 * Controller for report view screen, currently just shows the list of reports, which can be selected and viewed
 */
public class ViewReportsScreenController {

    @FXML
    private ListView reportList;
    @FXML
    private Label locLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label subLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label condLabel;
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane mapAnchorPane;


    /**
     * Setup listener for report list selection, populate list, and select first item initially
     */
    @FXML
    private void initialize() {
        reportList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WaterSourceReport>() {
            @Override
            public void changed(ObservableValue<? extends WaterSourceReport> observable, WaterSourceReport oldReport, WaterSourceReport newReport) {
                showReport(newReport);
            }
        });
        reportList.setItems(ReportList.soleInstance.get());
        if (reportList.getItems().size() == 0) {
            showReport(null);
        } else {
            reportList.getSelectionModel().selectFirst();
        }


    }


    /**
     * Make info label text reflect given report.
     * @param report
     */
    private void showReport(WaterSourceReport report) {
        if (report == null) {
            locLabel.setText("");
            dateLabel.setText("");
            idLabel.setText("");
            subLabel.setText("");
            typeLabel.setText("");
            condLabel.setText("");
        } else {
            locLabel.setText(report.getLocation().toString());
            dateLabel.setText(report.getReportTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            idLabel.setText(Integer.toString(report.getReportNumber()));
            subLabel.setText(report.getReporter().getUsername());
            typeLabel.setText(report.getWaterType().toString());
            condLabel.setText(report.getWaterCondition().toString());
        }
    }


    /**
     * Called when the back button is clicked, goes back to the application screen.
     */
    @FXML
    private void backClicked() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ApplicationScreen.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

