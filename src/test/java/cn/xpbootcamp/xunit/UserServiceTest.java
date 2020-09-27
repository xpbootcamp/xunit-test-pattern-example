package cn.xpbootcamp.xunit;

import cn.xpbootcamp.xunit.Util.AuditLogServiceTestSpy;
import cn.xpbootcamp.xunit.Util.UserRepoFakeObject;
import cn.xpbootcamp.xunit.Util.UserRepoTestStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_hand_code_stub() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoTestStub userRepoTestStub = new UserRepoTestStub();
        UserService service = new UserService(userRepoTestStub, new AuditLogService());

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    //@Test
    public void should_login_failed_when_user_login_given_invalid_user_name_and_password_use_hand_code_stub() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoTestStub userRepoTestStub = new UserRepoTestStub();
        UserService service = new UserService(userRepoTestStub, new AuditLogService());

        String token = service.login(userName, password);

        Assertions.assertNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_stub_framework() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoTestStub = mock(UserRepo.class);
        when(userRepoTestStub.getUserBy(userName)).thenReturn(new User(userName, password));
        UserService service = new UserService(userRepoTestStub, new AuditLogService());

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_audit_log_when_user_login_success_given_valid_user_name_and_password_use_hand_code_spy() {
        //手动实现Spy
        String userName = "lisa";
        String password = "lisa123";
        AuditLogServiceTestSpy logServiceTestSpy = new AuditLogServiceTestSpy();
        UserService service = new UserService(new UserRepoTestStub(), logServiceTestSpy);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        Assertions.assertEquals(userName, logServiceTestSpy.getUserName());
        Assertions.assertEquals(getCurrentDate(), logServiceTestSpy.getDate());
        Assertions.assertEquals("Login", logServiceTestSpy.getAction());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_audit_log_when_user_login_success_given_valid_user_name_and_password_use_framework_spy() {
        String userName = "lisa";
        String password = "lisa123";
        AuditLogService auditLogServiceTestSpy = spy(AuditLogService.class);
        UserService service = new UserService(new UserRepoTestStub(), auditLogServiceTestSpy);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        Assertions.assertEquals(userName, auditLogServiceTestSpy.getUserName());
        Assertions.assertEquals("Login", auditLogServiceTestSpy.getAction());
        Assertions.assertEquals(getCurrentDate(), auditLogServiceTestSpy.getDate());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_register_success_when_user_register_given_valid_user_name_and_password_use_mock() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoMockObject = mock(UserRepo.class);
        when(userRepoMockObject.getUserBy(userName)).thenReturn(null);
        UserService service = new UserService(userRepoMockObject, new AuditLogService());

        service.register(userName, password);

        verify(userRepoMockObject, times(1)).getUserBy(userName);
        verify(userRepoMockObject, times(1)).save(any());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_fake() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoFakeObject repoFakeObject = new UserRepoFakeObject();
        repoFakeObject.save(new User(userName, password));
        UserService service = new UserService(repoFakeObject, new AuditLogService());

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_dummy() {
        String userName = "lisa";
        String password = "lisa123";
        UserService service = new UserService(new UserRepoTestStub(), new AuditLogService());

        boolean dummyObject = true;
        String token = service.login(userName, password, dummyObject);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    private String getCurrentDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        try {
            return formatter.parse(formatter.format(today)).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
