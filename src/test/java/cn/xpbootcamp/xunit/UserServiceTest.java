package cn.xpbootcamp.xunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_stub() {
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
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_spy() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoTestSpy = spy(UserRepo.class);
        userRepoTestSpy.users.put(userName, password);
//        when(userRepoTestSpy.getUserBy(userName, password)).thenReturn(true);
        UserService service = new UserService(userRepoTestSpy);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        verify(userRepoTestSpy, times(1)).getUserBy(userName, password);

        //GC(garbage-collect)销毁数据
    }

    // spy创建了一个可运行的UserRepo类
    // mock object创建了一个虚拟的UserRepo类，所有的操作都需要打桩
    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_mock() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoMockObject = mock(UserRepo.class);
        when(userRepoMockObject.getUserBy(userName, password)).thenReturn(true);
        UserService service = new UserService(userRepoMockObject);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        verify(userRepoMockObject, times(1)).getUserBy(userName, password);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_fake() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoFakeObject repoFakeObject = new UserRepoFakeObject();
        UserService service = new UserService(repoFakeObject);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_dummy() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepo = new UserRepo();
        userRepo.users.put(userName, password);
        UserService service = new UserService(userRepo);

        boolean dummyObject = true;
        String token = service.login(userName, password, dummyObject);

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
