package mxd.ketabee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mxd.ketabee.dto.inbound.RegistrationRequest;
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

    public String registerUser(RegistrationRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        UserModel user = new UserModel();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        repoInstance.save(user);
        return "user saved";
    }

    public String deleteUser(Long id) {
        repoInstance.deleteById(id);
        return "user deleted";
    }

}
