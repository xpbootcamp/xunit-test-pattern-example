package cn.xpbootcamp.xunit;

import cn.xpbootcamp.xunit.db.MysqlDB;

public class UserRepo {

    private final MysqlDB db;

    public UserRepo(MysqlDB db) {
        this.db = db;
    }

    public User getUserBy(String userName) {
        return db.getUser(userName);
    }

    public void save(User user) {
        db.saveUser(user);
    }
}
