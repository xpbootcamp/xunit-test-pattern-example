package cn.xpbootcamp.xunit.Util;

import cn.xpbootcamp.xunit.AuditLogService;
import cn.xpbootcamp.xunit.UserAuditRepo;

public class AuditLogServiceTestSpy extends AuditLogService {
    private String username;
    private String action;
    private String date;
    private int numberCalled;

    public AuditLogServiceTestSpy(UserAuditRepo userAuditRepo) {
        super(userAuditRepo);
    }

    @Override
    public void log(String action, String userName, String date) {
        this.username = userName;
        this.action = action;
        this.date = date;
        numberCalled++;
    }

    public String getUserName() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public String getAction() {
        return action;
    }

    public int getNumberCalled() {
        return numberCalled;
    }
}
