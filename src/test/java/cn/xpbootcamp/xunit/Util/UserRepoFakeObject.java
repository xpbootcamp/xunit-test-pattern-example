package cn.xpbootcamp.xunit.Util;


import cn.xpbootcamp.xunit.UserRepo;

import java.util.HashMap;

public class UserRepoFakeObject extends UserRepo {
    HashMap<String, String> users = new HashMap<>();

    @Override
    public boolean getUserBy(String userName, String password) {
        return true;
    }

    @Override
    public void save(String userName, String password) {
    }
}
