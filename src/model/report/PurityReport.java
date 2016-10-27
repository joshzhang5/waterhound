package model.report;

import model.user.User;
import model.user.UserHashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  A user can submit this report any time they are logged in. This report consists of:
 *      Date and time of report (can be autogenerated by application)
 *      Report Number (must be autogenerated by application)
 *      Name of reporter (can be autogenerated from user information)
 *      Location of water (manually entered. using any kind of location services or gps is extra credit).
 *      Type of water (Bottled, Well, Stream, Lake, Spring, Other)
 *      Condition of water (Waste, Treatable-Clear, Treatable-Muddy, Potable)
 */
public class PurityReport {

    private LocalDateTime reportTime;
    private int reportNumber;
    private User reporter;
    private Location location;
    private GeneralCondition condition;
    private double virus;
    private double contamination;

    private static int numOfReports;

    /**
     * Create new purity report with the given data and autogenerated user, number, and timestamp.
     * @param latitude
     * @param longitude
     * @param condition
     * @param virus
     * @param contamination
     */
    public PurityReport(Double latitude, Double longitude, GeneralCondition condition, double virus, double contamination) {
        //Report time autogenerated when report is submitted
        reportTime = LocalDateTime.now();

        //Reporter is autogenerated as current user
        reporter = UserHashMap.soleInstance.getCurrentUser();

        //For now report number is just the number of reports created so far
        numOfReports++;
        reportNumber = numOfReports;

        this.location = new Location(latitude, longitude);
        this.condition = condition;
        this.virus = virus;
        this.contamination = contamination;
    }

    public LocalDateTime getReportTime() {
        return reportTime;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public User getReporter() {
        return reporter;
    }

    public Location getLocation() {
        return location;
    }

    public GeneralCondition getCondition() {
        return condition;
    }

    public double getVirus() { return virus; }

    public double getContamination() { return contamination; }

    @Override
    public String toString() {
        return location + ", " + reportTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}