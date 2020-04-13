package ma.cs.dolibar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DolibarApplicationTests {

	@Autowired
	private UserControlller controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

  @Test
  public void post_entity_should_return_ok() throws Exception {

    User user = null;
    assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/", user, User.class))
        .isEqualTo(user);
		}
}
