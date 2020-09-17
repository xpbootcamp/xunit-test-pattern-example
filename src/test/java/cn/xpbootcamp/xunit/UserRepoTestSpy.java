package cn.xpbootcamp.xunit;

import java.util.HashMap;

public class UserRepoTestSpy extends UserRepo {
    public UserRepoTestSpy() {
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
}
