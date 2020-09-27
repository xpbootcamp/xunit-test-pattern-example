package cn.xpbootcamp.xunit.Util;


import cn.xpbootcamp.xunit.User;
import cn.xpbootcamp.xunit.UserRepo;
import cn.xpbootcamp.xunit.db.MysqlDB;

public class UserRepoTestStub extends UserRepo {

    public UserRepoTestStub(MysqlDB db) {
        super(db);
    }

    // use by SUT
    @Override
    public User getUserBy(String userName) {
        return new User("lisa", "lisa123");
        //        return new User("invalidName", "invalidPassword");
    }
}
