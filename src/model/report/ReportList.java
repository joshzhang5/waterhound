package model.report;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton list of reports, will eventually be moved to database
 */
public enum ReportList {
    soleInstance;

    private ObservableList reports = FXCollections.observableArrayList();

    public void add(WaterSourceReport report) {
        reports.add(report);
    }

    public ObservableList get() {
        return reports;
    }

}
