package model.user;

/**
 * Enum for user types. Used in registration screen
 */
public enum UserType {
    BASIC_USER ("User", 1),
    WORKER ("Worker", 2),
    MANAGER ("Manager", 3),
    ADMIN ("Admin", 0);

    private final String name;
    private final int level;

    UserType(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String toString() { return name; }
    public int getLevel() { return level; }
}
