package Aram.WebServiceBooks.login.controller;

import Aram.WebServiceBooks.login.filter.PasswordValidator;
import Aram.WebServiceBooks.login.model.AuthRequest;
import Aram.WebServiceBooks.login.model.Roles;
import Aram.WebServiceBooks.login.model.UserEntity;
import Aram.WebServiceBooks.login.service.JWTService;
import Aram.WebServiceBooks.login.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    // Constructor for UserController, it takes an AuthenticationManager, UserService, PasswordEncoder, and JWTService as parameters.
    public AuthController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest user) {

        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        } else {

            String badPass = PasswordValidator.validatePassword(user.getPassword());
            if (!badPass.equals("")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badPass);
            }
            UserEntity newUser = new UserEntity();
            newUser.setUsername(user.getUsername());
            newUser.setRole(Roles.ROLE_USER);
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));

            userService.save(newUser);
            return ResponseEntity.status(HttpStatus.OK).body("Registration successful!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                return new ResponseEntity<>(jwtService.generateToken(authRequest.getUsername()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong username or password");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong username or password");
    }
}
