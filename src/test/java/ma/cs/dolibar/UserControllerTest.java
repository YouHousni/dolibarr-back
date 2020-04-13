package ma.cs.dolibar;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserControlller.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

  @Test
  public void post_entity_should_return_ok() throws Exception {
    Mockito.when(service.create(ArgumentMatchers.any())).thenReturn(null);

    this.mockMvc
        .perform(post("/users"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().string(CoreMatchers.containsString("A")));
  }

}
