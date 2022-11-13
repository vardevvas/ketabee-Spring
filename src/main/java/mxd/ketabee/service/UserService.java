package mxd.ketabee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mxd.ketabee.model.UserModel;
import mxd.ketabee.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repoInstance;

    public ResponseEntity<?> userList() {
        List<UserModel> userList = new ArrayList<>();
        repoInstance.findAll().forEach(userList::add);
        return ResponseEntity.ok().body(userList);
    }

    public ResponseEntity<?> getUser(Long Id) {
        return ResponseEntity.ok().body(repoInstance.findById(Id).get());
    }

    public ResponseEntity<?> addUser(UserModel user) {
        repoInstance.save(user);
        return ResponseEntity.ok().body("user saved");
    }

}
