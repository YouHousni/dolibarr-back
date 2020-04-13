package ma.cs.dolibar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControlller {

    private UserService userService;

    public UserControlller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);

    }
}
