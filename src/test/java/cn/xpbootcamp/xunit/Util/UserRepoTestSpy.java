package cn.xpbootcamp.xunit.Util;

import cn.xpbootcamp.xunit.UserRepo;

import java.util.HashMap;

public class UserRepoTestSpy extends UserRepo {
    public UserRepoTestSpy() {
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
}
