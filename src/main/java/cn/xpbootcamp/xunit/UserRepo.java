package cn.xpbootcamp.xunit;

import java.util.HashMap;

public class UserRepo {
    HashMap<String, String> users = new HashMap<>();

    public boolean getUserBy(String userName, String password) {
        return users.containsKey(userName) && users.get(userName).equals(password);
    }

    public void save(String userName, String password) {
        users.put(userName, password);
    }
}