package ma.cs.dolibar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "",configuration = DolibarConfiguration.class)
public interface UserClient {

  @PostMapping
  void postUser(@RequestBody User user);
}
