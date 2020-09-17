package cn.xpbootcamp.xunit.Util;


import cn.xpbootcamp.xunit.User;
import cn.xpbootcamp.xunit.UserRepo;

import java.util.HashMap;

public class UserRepoFakeObject extends UserRepo {
    HashMap<String, User> users = new HashMap<>();

    @Override
    public User getUserBy(String userName) {
        return users.get(userName);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }
}
