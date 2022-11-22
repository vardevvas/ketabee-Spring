package mxd.ketabee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "Username")
    private String username;
    // @Column(name = "Password")
    private String password;
    // @Column(name = "First Name")
    private String firstname;
    // @Column(name = "Last Name")
    private String lastname;
    // @Column(name = "Email")
    private String email;
    // @Column(name = "Roles")
    private String role;

}
