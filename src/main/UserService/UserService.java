package UserService;

import java.util.HashMap;

public class UserService {
    private final HashMap<String, String> users;

    public UserService(HashMap<String, String> users) {
        this.users = users;
    }

    public void login(String userName, String password) {
        if (userName != null && password != null) {
            users.put(userName, password);
        }
    }
}