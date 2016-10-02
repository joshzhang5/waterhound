package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kruby on 10/2/16.
 */
public enum UserHashMap {
    soleInstance;

    private Map<String,User> users = new HashMap<String,User>();

    public void add(User user) {
        users.put(user.getUsername(), user);
    }

    public User get(String username) {
        return users.get(username);
    }
}
