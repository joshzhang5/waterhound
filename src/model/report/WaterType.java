package model.report;

/**
 * Type of water for WaterSource Report
 */
public enum WaterType {
    BOTTLED("Bottled"),
    WELL("Well"),
    STREAM("Stream"),
    LAKE("Lake"),
    SPRING("Spring"),
    OTHER ("Other");

    private final String name;

    WaterType(String name) {
        this.name = name;
    }

    public String toString() { return name; }
}
