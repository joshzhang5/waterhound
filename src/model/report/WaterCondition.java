package model.report;

/**
 * Condition of water (Waste, Treatable-Clear, Treatable-Muddy, Potable)
 */
public enum WaterCondition {
    WASTE("Waste"),
    TREATABLE_CLEAR("Treatable-Clear"),
    TREATABLE_MUDDY("Treatable-Muddy"),
    POTABLE("Potable");

    private final String name;

    WaterCondition(String name) {
        this.name = name;
    }

    public String toString() { return name; }
}
