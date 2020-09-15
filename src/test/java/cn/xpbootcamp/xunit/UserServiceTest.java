package cn.xpbootcamp.xunit;

import cn.xpbootcamp.xunit.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class UserServiceTest {
    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        HashMap<String, String> users = new HashMap<>();
        UserService service = new UserService(users);

        service.login(userName, password);

        Assertions.assertEquals(users.get(userName), password);
    }
}
