package ma.cs.dolibar;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String login;
    private String password;
    private String entity;
    private Integer reset;
}
