package model.user;

/**
 * Represents a user in the system
 */
public class User {
    private String username;
    private String password;
    private String name;
    private UserType type;
    private String email;
    private String homeAddress;
    private String title;

    public User(String username, String password, String name, UserType type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.type = type;
    }

    public boolean isCorrectPassword(String pw) {
        return pw.equals(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }
}
