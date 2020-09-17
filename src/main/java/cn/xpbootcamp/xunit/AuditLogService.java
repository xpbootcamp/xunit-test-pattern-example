package cn.xpbootcamp.xunit;

public class AuditLogService {
    private String action;
    private String userName;
    private String date;

    public void log(String login, String userName, String date) {

        this.action = login;
        this.userName = userName;
        this.date = date;
        // audit
    }

    public String getAction() {
        return action;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }
}
