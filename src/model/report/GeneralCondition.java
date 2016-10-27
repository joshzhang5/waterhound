package model.report;

/**
 * General condition of water (Safe, Treatable, Unsafe)
 */
public enum GeneralCondition {
    SAFE("Safe"),
    TREATABLE("Treatable"),
    UNSAFE("Unsafe");

    private final String name;

    GeneralCondition(String name) {
        this.name = name;
    }

    public String toString() { return name; }
}
