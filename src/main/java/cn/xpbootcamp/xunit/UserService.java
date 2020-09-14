package cn.xpbootcamp.xunit;

import java.util.HashMap;

public class UserService {
    private final HashMap<String, String> users;

    public UserService(HashMap<String, String> users) {
        this.users = users;
    }

    public String login(String userName, String password) {
        if (users.containsKey(userName) && users.get(userName).equals(password)) {
            return "";
        }
        return null;
    }

    public void register(String userName, String password) {
        if (!userName.isEmpty() && !password.isEmpty()) {
            users.put(userName, password);
        }
    }
}