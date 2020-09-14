package UserServiceTest;

import UserService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";

        UserService service = new UserService();
        long userId = service.login(userName, password);

        Assertions.assertEquals(userId, 123);
    }
}
