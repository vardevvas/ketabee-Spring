package mxd.ketabee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mxd.ketabee.model.UserModel;
import mxd.ketabee.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    // private final AuthenticationManager authenticationManager;

    @Autowired
    UserService serviceInstance;

    @GetMapping("/users")
    ResponseEntity<?> userList() {
        return new ResponseEntity<>(serviceInstance.userList(), HttpStatus.OK);
    }

    @GetMapping("/users/{Id}")
    ResponseEntity<?> getUser(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.getUser(Id), HttpStatus.OK);
    }

    // @PostMapping("/login")
    // void login(@RequestBody LoginRequest loginRequest) {
    // Authentication authentication = authenticationManager.authenticate(
    // new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
    // loginRequest.getPassword()));
    // }

    @PostMapping("/registration")
    ResponseEntity<?> addUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(serviceInstance.registerUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{Id}")
    ResponseEntity<?> deleteUser(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.deleteUser(Id), HttpStatus.OK);
    }

}

// @Data
// class LoginRequest {
// private String username;
// private String password;
// }
