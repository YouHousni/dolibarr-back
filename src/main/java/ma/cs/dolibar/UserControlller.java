package ma.cs.dolibar;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserControlller {

    private UserService userService;

    public UserControlller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User create(@RequestBody User user){
        return userService.create(user);

    }

    @GetMapping("/users")
    public List<User> list(String token){
        return userService.list(token);
    }

    @PostMapping("/login")
    public String login(@RequestBody Account account){
        return userService.login(account);
    }
}
