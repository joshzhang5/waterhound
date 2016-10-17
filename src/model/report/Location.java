package model.report;

/**
 * Created by kruby on 10/17/16.
 */
public class Location {
    private double latitude;
    private double longitude;

    public Location(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return latitude + " , " + longitude;
    }
}
