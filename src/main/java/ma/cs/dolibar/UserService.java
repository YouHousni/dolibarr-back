package ma.cs.dolibar;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserClient userClient;

    public User create(User user) {
        userClient.postUser(user);
        return user;
    }
}
