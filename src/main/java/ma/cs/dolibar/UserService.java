package ma.cs.dolibar;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User create(User user) {
        userClient.postUser(user);
        return user;
    }


    public List<User> list(String token){
        return userClient.list(token,"t.rowid","ASC",100);
    }


    public String login(@RequestBody Account account){
        return userClient.login(account).getSuccess().getToken();
    }
}
