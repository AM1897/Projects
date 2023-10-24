package Aram.kafka.controller;

import Aram.kafka.Kafka.TextMessageKafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController // denna klass är en rest controller
@RequestMapping("/api/v1/kafka")    // denna klass har en request mapping
public class TextMessageController {    // denna klass är en controller för textmeddelanden

    private final TextMessageKafkaProducer kafkaProducer;   // denna klass har en kafka producer

    public TextMessageController(TextMessageKafkaProducer kafkaProducer) {  // konstruktor
        this.kafkaProducer = kafkaProducer; // sätter kafka producer
    }

    @GetMapping("/publish") // denna klass har en get mapping
    public ResponseEntity<String> publish(@RequestParam("message") String message) {    // denna klass har en response entity
        try {
            kafkaProducer.sendMessage(message); // skickar meddelande
            return ResponseEntity.ok("Published successfully"); // returnerar response entity
        } catch (Exception e) { // fångar exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)  // returnerar response entity
                    .body("Failed to publish message: " + e.getMessage());
        }
    }
}

