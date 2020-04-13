package ma.cs.dolibar;


import lombok.Data;

@Data
public class LoginResponse {
    private Success success;
}

@Data
class Success {
    private Integer code;
    private String token;
    private Integer entity;
    private String  message;

}
