package cn.xpbootcamp.xunit.Util;

import cn.xpbootcamp.xunit.db.H2DB;
import cn.xpbootcamp.xunit.db.MysqlDB;
import cn.xpbootcamp.xunit.User;

public class FakeInMemoryDB extends MysqlDB {
    private final H2DB db;

    public FakeInMemoryDB() {
        this.db = new H2DB().connect();
    }

    @Override
    public User getUser(String userName) {
        return db.getUser(userName);
    }

    @Override
    public void saveUser(User user) {
        db.saveUser(user);
    }
}
