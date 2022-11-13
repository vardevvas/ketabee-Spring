package mxd.ketabee.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mxd.ketabee.model.UserModel;
import mxd.ketabee.repository.UserRepository;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repoInstance;

    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<?> userList() {
        List<UserModel> userList = new ArrayList<>();
        repoInstance.findAll().forEach(userList::add);
        return ResponseEntity.ok().body(userList);
    }

    public ResponseEntity<?> getUser(Long Id) {
        return ResponseEntity.ok().body(repoInstance.findById(Id).get());
    }

    public ResponseEntity<?> registerUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repoInstance.save(user);

        return ResponseEntity.ok().body("user saved");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = repoInstance.findByUsername(username);
        if (user == null) {
            log.error("{} not found", username);
            throw new UsernameNotFoundException("username not found");
        } else {
            log.info("{} found", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
