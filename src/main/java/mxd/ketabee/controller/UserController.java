package mxd.ketabee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mxd.ketabee.dto.inbound.RegistrationRequest;
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
    ResponseEntity<String> addUser(@Valid @RequestBody RegistrationRequest request, BindingResult requestcheck) {
        if (requestcheck.hasErrors()) {
            String response = "Request is invalid";
            return ResponseEntity.badRequest().body(response);
        }
        return new ResponseEntity<>(serviceInstance.registerUser(request), HttpStatus.OK);
    }

    @DeleteMapping("/users/{Id}")
    ResponseEntity<String> deleteUser(@PathVariable Long Id) {
        return new ResponseEntity<>(serviceInstance.deleteUser(Id), HttpStatus.OK);
    }

}