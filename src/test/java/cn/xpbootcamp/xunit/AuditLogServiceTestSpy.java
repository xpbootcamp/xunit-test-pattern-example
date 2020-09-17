package cn.xpbootcamp.xunit;

public class AuditLogServiceTestSpy extends AuditLogService {
    private String username;
    private String action;
    private String date;

    @Override
    public void log(String action, String userName, String date) {
        this.username = userName;
        this.action = action;
        this.date = date;
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
}
