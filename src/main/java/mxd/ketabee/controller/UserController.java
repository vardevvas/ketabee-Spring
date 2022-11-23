package mxd.ketabee.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mxd.ketabee.model.UserModel;
import mxd.ketabee.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService serviceInstance;

    @GetMapping("/users")
    ResponseEntity<List<UserModel>> userList() {
        return new ResponseEntity<>(serviceInstance.userList(), HttpStatus.OK);
    }

    @GetMapping("/users/{Id}")
    ResponseEntity<Optional<UserModel>> getUser(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.getUser(Id), HttpStatus.OK);
    }

    @PostMapping("/registration")
    ResponseEntity<String> addUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(serviceInstance.registerUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{Id}")
    ResponseEntity<String> deleteUser(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.deleteUser(Id), HttpStatus.OK);
    }

}
// @PostMapping("/login")
// void login(@RequestBody LoginRequest loginRequest) {
// Authentication authentication = authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
// loginRequest.getPassword()));
// }
// @Data
// class LoginRequest {
// private String username;
// private String password;
// }
