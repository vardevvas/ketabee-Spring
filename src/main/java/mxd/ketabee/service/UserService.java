package mxd.ketabee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mxd.ketabee.model.UserModel;
import mxd.ketabee.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repoInstance;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserModel> userList() {
        return repoInstance.findAll();
    }

    public Optional<UserModel> getUser(Long Id) {
        return repoInstance.findById(Id);
    }

    public UserModel getUserByUsername(String username) {
        return repoInstance.findByUsername(username);
    }

    public String registerUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repoInstance.save(user);
        return "user saved";
    }

    public String deleteUser(Long id) {
        repoInstance.deleteById(id);
        return "user deleted";
    }

}
