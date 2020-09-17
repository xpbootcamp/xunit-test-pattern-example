package cn.xpbootcamp.xunit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {
    private final UserRepo userRepo;
    private final AuditLogService auditLogService;

    public UserService(UserRepo userRepo, AuditLogService auditLogService) {
        this.userRepo = userRepo;
        this.auditLogService = auditLogService;
    }

    public String login(String userName, String password, boolean isUser) {
        String currentDate = getCurrentDate();
        User user = userRepo.getUserBy(userName);
        if (user != null && user.getPassword().equals(password)) {
            auditLogService.log("Login", userName, currentDate);
            return "Token";
        }
        if (isUser) {
            auditLogService.log("Login", userName, currentDate);
            return "USER-Token";
        }
        return null;
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

    public void register(String userName, String password) {
        if (!userName.isEmpty() && !password.isEmpty() && userRepo.getUserBy(userName) == null) {
            userRepo.save(new User(userName, password));
        }
    }

    public String login(String userName, String password) {
        return login(userName, password, false);
    }
}