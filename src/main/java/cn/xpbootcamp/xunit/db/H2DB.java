package cn.xpbootcamp.xunit.db;

import cn.xpbootcamp.xunit.User;

import java.util.HashMap;

public class H2DB extends MysqlDB {
    private HashMap<String, String> users;

    public H2DB connect() {
        users = new HashMap<>();
        return this;
    }

    public User getUser(String userName) {
        if (users.containsKey(userName)) {
            return new User(userName, users.get(userName));
        }
        return null;
    }

    public void saveUser(User user) {
        users.put(user.getName(), user.getPassword());
    }
}
