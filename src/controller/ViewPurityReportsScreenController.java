package controller;

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
import javafx.stage.Stage;
import model.report.PurityReport;
import model.report.PurityReportList;
import model.report.ReportList;
import model.report.WaterSourceReport;

import java.time.format.DateTimeFormatter;

/**
 * Controller for report view screen, currently just shows the list of reports, which can be selected and viewed
 */
public class ViewPurityReportsScreenController {

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
    private Label condLabel;
    @FXML
    private Label virusLabel;
    @FXML
    private Label contamLabel;
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane mapAnchorPane;


    /**
     * Setup listener for report list selection, populate list, and select first item initially
     */
    @FXML
    private void initialize() {
        reportList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PurityReport>() {
            @Override
            public void changed(ObservableValue<? extends PurityReport> observable, PurityReport oldReport, PurityReport newReport) {
                showReport(newReport);
            }
        });
        reportList.setItems(PurityReportList.soleInstance.get());
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
    private void showReport(PurityReport report) {
        if (report == null) {
            locLabel.setText("");
            dateLabel.setText("");
            idLabel.setText("");
            subLabel.setText("");
            condLabel.setText("");
            virusLabel.setText("");
            contamLabel.setText("");
        } else {
            locLabel.setText(report.getLocation().toString());
            dateLabel.setText(report.getReportTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            idLabel.setText(Integer.toString(report.getReportNumber()));
            subLabel.setText(report.getReporter().getUsername());
            condLabel.setText(report.getCondition().toString());
            virusLabel.setText(Double.toString(report.getVirus()));
            contamLabel.setText(Double.toString(report.getContamination()));
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

