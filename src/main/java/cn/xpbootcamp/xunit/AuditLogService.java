package cn.xpbootcamp.xunit;

public class AuditLogService {

    private final UserAuditRepo userAuditRepo;

    public AuditLogService(UserAuditRepo userAuditRepo) {
        this.userAuditRepo = userAuditRepo;
    }

    public void log(String action, String userName, String date) {
        userAuditRepo.save(action, userName, date);
    }
}
