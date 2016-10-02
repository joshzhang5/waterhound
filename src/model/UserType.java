package model;

/**
 * Enum for user types. Used in registration screen
 */
public enum UserType {
    BASIC_USER ("User"),
    WORKER ("Worker"),
    MANAGER ("Manager"),
    ADMIN ("Admin");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    public String toString() { return name; }
}
