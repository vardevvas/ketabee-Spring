package mxd.ketabee.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class UserModel {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String mailid;
    private String usertype;

}
