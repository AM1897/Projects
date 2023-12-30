package teamwordk.WebServiceApi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import teamwordk.WebServiceApi.login.model.UserEntity;
import teamwordk.WebServiceApi.login.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
        if (userService.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>("Användarnamnet är redan taget", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return new ResponseEntity<>("Användare registrerad framgångsrikt", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
        UserEntity existingUser = userService.findByUsername(user.getUsername()).orElse(null);
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            String token = "token-skulle-genereras-här";
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Inloggningsuppgifterna är ogiltiga", HttpStatus.UNAUTHORIZED);
    }
}
