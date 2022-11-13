package mxd.ketabee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mxd.ketabee.model.UserModel;
import mxd.ketabee.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService serviceInstance;

    @GetMapping("/userList")
    ResponseEntity<?> userList() {
        return serviceInstance.userList();
    }

    @GetMapping("/booklist/{Id}")
    ResponseEntity<?> getUser(@PathVariable Long Id) {
        return serviceInstance.getUser(Id);
    }

    @PostMapping("/adduser")
    ResponseEntity<?> getUser(@RequestBody UserModel user) {
        return serviceInstance.addUser(user);
    }
}
