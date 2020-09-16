package cn.xpbootcamp.xunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoTestStub = mock(UserRepo.class);
        when(userRepoTestStub.getUserBy(userName, password)).thenReturn(true);
        UserService service = new UserService(userRepoTestStub);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_fail_when_user_login_given_invalid_user_name_and_password() {
        String invalidUserName = "li,_sa";
        String password = "lisa123";
        UserRepo userRepoTestStub = mock(UserRepo.class);
        when(userRepoTestStub.getUserBy(invalidUserName, password)).thenReturn(false);
        UserService service = new UserService(userRepoTestStub);

        String token = service.login(invalidUserName, password);

        Assertions.assertNull(token);

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
