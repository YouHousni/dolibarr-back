package ma.cs.dolibar;

import feign.Feign;
import feign.slf4j.Slf4jLogger;
import lombok.extern.java.Log;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserClientTest {

    @Autowired
    UserClient userClient ;

    static String token;

    @Test
    @Order(1)
    public void contexLoads() throws Exception {
        assertThat(userClient).isNotNull();
    }


    @Test
    @Order(2)
    public void login_shoud_return_token() throws Exception {
        // GIVEN
        Account account = new Account("admin","123@azer","",0);

        LoginResponse loginResponse=userClient.login(account);

        assertThat(loginResponse).isNotNull();

        token = loginResponse.getSuccess().getToken();

        assertThat(loginResponse.getSuccess().getToken()).isNotNull();

    }

    @Test
    @Order(3)
    public void users_shoud_return_list() throws Exception {


        List<User> users=userClient.list(token,"t.rowid","ASC",100);

        assertThat(users).isNotNull();

        System.out.println(users);
    }
}
