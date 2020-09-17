package cn.xpbootcamp.xunit;

public class SQLiteJDBC {

    public SQLiteJDBC() {

    }


    public void saveUser(User user) {
    }

    public User getUser(String userName) {
        return new User("db", "dbuser");
    }
}
