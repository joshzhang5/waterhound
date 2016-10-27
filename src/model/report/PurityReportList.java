package model.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Singleton list of reports, will eventually be moved to database
 */
public enum PurityReportList {
    soleInstance;

    private ObservableList reports = FXCollections.observableArrayList();

    public void add(PurityReport report) {
        reports.add(report);
    }

    public ObservableList get() {
        return reports;
    }

}
