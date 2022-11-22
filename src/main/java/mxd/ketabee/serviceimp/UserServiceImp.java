package mxd.ketabee.serviceimp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mxd.ketabee.model.UserModel;
import mxd.ketabee.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImp implements UserDetailsService {

    @Autowired
    UserRepository repoInstance;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = repoInstance.findByUsername(username);
        if (user == null) {
            log.error("{} not found", username);
            throw new UsernameNotFoundException("username not found");
        } else {
            log.info("{} found", username);
        }
        List<SimpleGrantedAuthority> authorities = Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
