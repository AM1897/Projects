package Aram.WebServiceBooks.login.service;


import Aram.WebServiceBooks.login.model.SecurityUser;
import Aram.WebServiceBooks.login.model.UserEntity;
import Aram.WebServiceBooks.login.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;

    public JpaUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            // If a user with the given username exists, a new SecurityUser is created from the UserEntity and returned.
            return new SecurityUser(optionalUser.get());
        } else {
            // If a user with the given username does not exist, a UsernameNotFoundException is thrown.
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
