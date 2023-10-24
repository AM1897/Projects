package Aram.kafka.controller;

import Aram.kafka.Kafka.JsonKafkaProducer;
import Aram.kafka.Repository.UserRepository;
import Aram.kafka.payload.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // @Controller + @ResponseBody (returnerar JSON) på alla metoder i klassen
@RequestMapping("/api/v1/kafka")    // alla metoder i klassen har denna path
public class UserEventController {  // klassen är en RestController
    private final JsonKafkaProducer kafkaProducer;  // Denna klass är en dependency till denna klass och skapas i konstruktorn nedan
        private final UserRepository userRepository;

    // Konstruktor som skapar en instans av JsonKafkaProducer och UserRepository
    public UserEventController(JsonKafkaProducer kafkaProducer, UserRepository userRepository) {
        this.kafkaProducer = kafkaProducer;
        this.userRepository = userRepository;
    }

    // Metod som tar emot en User och skickar den till JsonKafkaProducer som skickar den till Kafka
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        try {
            kafkaProducer.sendMessage(user);
            return ResponseEntity.ok("Json Message sent to Kafka Topic successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send Json message to Kafka Topic: " + e.getMessage());
        }
    }

    // Metod som tar emot en User och sparar den i databasen
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Metod som tar emot en User och sparar den i databasen
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User userUpdates) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userUpdates.setId(id);
            userRepository.save(userUpdates);
            return ResponseEntity.ok("Användare uppdaterad");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Användare inte funnen");
        }
    }

    // Metod som tar emot en User och sparar den i databasen
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Användare raderad");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Användare inte funnen");
        }
    }
}
