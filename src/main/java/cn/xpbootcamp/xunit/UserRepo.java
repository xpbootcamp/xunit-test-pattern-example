package cn.xpbootcamp.xunit;

public class UserRepo {

    private final SQLiteJDBC db = new SQLiteJDBC();

    public User getUserBy(String userName) {
        return db.getUser(userName);
    }

    public void save(User user) {
        db.saveUser(user);
    }
}
