package java.cn.xpbootcamp.xunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class UserServiceTest {
    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        HashMap<String, String> users = new HashMap<>();
        users.put(userName, password);
        UserService service = new UserService(users);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_register_success_when_user_register_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        HashMap<String, String> users = new HashMap<>();
        var service = new UserService(users);

        service.register(userName, password);

        Assertions.assertEquals(password, users.get(userName));
    }
}
