package model.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton hashmap of users, planning on moving to database
 */
public enum UserHashMap {
    soleInstance;

    private User currentUser; //Will be moved to security manager when that gets made

    private Map<String,User> users = new HashMap<String,User>();

    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    public User get(String username) {
        return users.get(username);
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
