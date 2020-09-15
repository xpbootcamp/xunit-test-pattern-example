package cn.xpbootcamp.xunit;

public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String login(String userName, String password) {
        if (userRepo.getUserBy(userName, password)) {
            return "";
        }
        return null;
    }

    public void register(String userName, String password) {
        if (!userName.isEmpty() && !password.isEmpty()) {
            userRepo.save(userName, password);
        }
    }
}