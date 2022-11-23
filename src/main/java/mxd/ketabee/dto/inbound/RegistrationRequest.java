package mxd.ketabee.dto.inbound;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

}
