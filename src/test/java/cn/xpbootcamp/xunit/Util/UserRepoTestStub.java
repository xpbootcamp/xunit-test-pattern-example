package cn.xpbootcamp.xunit.Util;


import cn.xpbootcamp.xunit.UserRepo;

public class UserRepoTestStub extends UserRepo {
    public void setUser(String username, String password) {
        users.put(username, password);
    }

    // use by SUT
    @Override
    public boolean getUserBy(String userName, String password) {
        return true;
    }
}
