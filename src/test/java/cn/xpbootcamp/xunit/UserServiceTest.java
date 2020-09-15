package cn.xpbootcamp.xunit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepo = new UserRepo();
        userRepo.save(userName, password);
        UserService service = new UserService(userRepo);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_register_success_when_user_register_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepo = new UserRepo();
        UserService service = new UserService(userRepo);

        service.register(userName, password);

        Assertions.assertTrue(userRepo.getUserBy(userName, password));
    }
}
