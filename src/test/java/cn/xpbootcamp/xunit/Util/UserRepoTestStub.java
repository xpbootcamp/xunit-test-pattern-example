package cn.xpbootcamp.xunit.Util;


import cn.xpbootcamp.xunit.User;
import cn.xpbootcamp.xunit.UserRepo;

public class UserRepoTestStub extends UserRepo {

    // use by SUT
    @Override
    public User getUserBy(String userName) {
        return new User("lisa", "lisa123");
        //        return new User("invalidName", "invalidPassword");
    }
}
