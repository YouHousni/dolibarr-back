package ma.cs.dolibar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "dolibar",url = "http://daf.cloudandsteam.ma/api/index.php")
public interface UserClient {

  @PostMapping("/users")
  void postUser(@RequestBody User user);

  @GetMapping("/users")
  List<User> list(@RequestHeader(value = "DOLAPIKEY") String token,
                  @RequestParam(value = "sortfield") String sortfield,
                  @RequestParam(value = "sortorder") String sortorder,
                  @RequestParam(value = "limit") Integer limit);


  //curl -X GET --header 'Accept: application/json' --header 'DOLAPIKEY: 4ea58eed9de23844315872124a12cfac58c7588e' 'http://daf.cloudandsteam.ma/api/index.php/users?sortfield=t.rowid&sortorder=ASC&limit=100'
  @PostMapping("/login")
  LoginResponse login( @RequestBody Account acount);

}
