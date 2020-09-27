package cn.xpbootcamp.xunit;

import cn.xpbootcamp.xunit.Util.AuditLogServiceTestSpy;
import cn.xpbootcamp.xunit.Util.FakeInMemoryDB;
import cn.xpbootcamp.xunit.Util.UserRepoTestStub;
import cn.xpbootcamp.xunit.db.MysqlDB;
import cn.xpbootcamp.xunit.repo.UserAuditRepo;
import cn.xpbootcamp.xunit.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    private MysqlDB db;

    @BeforeEach
    void setUp() {
        db = new MysqlDB();
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_hand_code_stub() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoTestStub userRepoTestStub = new UserRepoTestStub(db);
        UserService service = new UserService(userRepoTestStub, new AuditLogService(new UserAuditRepo()));

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    //@Test
    public void should_login_failed_when_user_login_given_invalid_user_name_and_password_use_hand_code_stub() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepoTestStub userRepoTestStub = new UserRepoTestStub(db);
        UserService service = new UserService(userRepoTestStub, new AuditLogService(new UserAuditRepo()));

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
        UserService service = new UserService(userRepoTestStub, new AuditLogService(new UserAuditRepo()));

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_audit_log_when_user_login_success_given_valid_user_name_and_password_use_hand_code_spy() {
        String userName = "lisa";
        String password = "lisa123";
        AuditLogServiceTestSpy logServiceTestSpy = new AuditLogServiceTestSpy(new UserAuditRepo());
        UserService service = new UserService(new UserRepoTestStub(db), logServiceTestSpy);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        Assertions.assertEquals(1, logServiceTestSpy.getNumberCalled());
        Assertions.assertEquals(userName, logServiceTestSpy.getUserName());
        Assertions.assertEquals(getCurrentDate(), logServiceTestSpy.getDate());
        Assertions.assertEquals("Login", logServiceTestSpy.getAction());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_audit_log_when_user_login_success_given_valid_user_name_and_password_use_framework_spy() {
        String userName = "lisa";
        String password = "lisa123";
        AuditLogService auditLogServiceTestSpy = spy(new AuditLogService(new UserAuditRepo()));
        UserService service = new UserService(new UserRepoTestStub(db), auditLogServiceTestSpy);

        String token = service.login(userName, password);

        Assertions.assertNotNull(token);
        verify(auditLogServiceTestSpy, times(1)).log("Login", userName, getCurrentDate());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void use_spy_of_hash_map() {
        HashMap<String, String> spy = spy(HashMap.class);
        when(spy.put("1", "2")).thenReturn(null);
        spy.put("1", "2");
        spy.put("2", "3");

        Assertions.assertEquals(2, spy.size());
    }

    @Test
    public void use_mock_of_hash_map() {
        HashMap<String, String> spy = mock(HashMap.class);
        when(spy.put("1", "2")).thenReturn(null);
        spy.put("1", "2");
        spy.put("2", "3");

        Assertions.assertEquals(0, spy.size());
    }

    @Test
    public void should_register_success_when_user_register_given_valid_user_name_and_password_use_mock() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepoMockObject = mock(UserRepo.class);
        when(userRepoMockObject.getUserBy(userName)).thenReturn(null);
        UserService service = new UserService(userRepoMockObject, new AuditLogService(new UserAuditRepo()));

        service.register(userName, password);

        verify(userRepoMockObject, times(1)).getUserBy(userName);
        verify(userRepoMockObject, times(1)).save(any());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_save_user_to_db_when_save_user_given_valid_user_name_and_password_use_fake() {
        String userName = "lisa";
        String password = "lisa123";
        UserRepo userRepo = new UserRepo(new FakeInMemoryDB());

        userRepo.save(new User(userName, password));

        User user = userRepo.getUserBy(userName);
        Assertions.assertEquals(userName, user.getName());
        Assertions.assertEquals(password, user.getPassword());

        //GC(garbage-collect)销毁数据
    }

    @Test
    public void should_login_success_when_user_login_given_valid_user_name_and_password_use_dummy() {
        String userName = "lisa";
        String password = "lisa123";
        UserService service = new UserService(new UserRepoTestStub(db), new AuditLogService(new UserAuditRepo()));

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
