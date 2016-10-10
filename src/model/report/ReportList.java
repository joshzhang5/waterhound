package model.report;

import javafx.collections.FXCollections;
import model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton list of reports, will eventually be moved to database
 */
public enum ReportList {
    soleInstance;

    private List reports = FXCollections.observableArrayList();

    public void add(WaterSourceReport report) {
        reports.add(report);
    }

    public List get() {
        return reports;
    }

}
