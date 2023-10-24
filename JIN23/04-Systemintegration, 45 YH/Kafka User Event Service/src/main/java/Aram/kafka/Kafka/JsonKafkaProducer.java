package Aram.kafka.Kafka;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import Aram.kafka.payload.User;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@Service    // @Service annotation is used to mark the class as a service provider
public class JsonKafkaProducer { // JsonKafkaProducer class is used to send the JSON data to the Kafka topic
    private static final Logger LOGGER = LoggerFactory.getLogger((JsonKafkaProducer.class));    // Logger is used to log the messages

    private KafkaTemplate<String, User> kafkaTemplate;  // KafkaTemplate is used to send the JSON data to the Kafka topic
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {   // KafkaTemplate is used to send the JSON data to the Kafka topic
        this.kafkaTemplate = kafkaTemplate;
    }  // KafkaTemplate is used to send the JSON data to the Kafka topic
    public void sendMessage(User data) { // här skickar vi meddelandet till kafka
        LOGGER.info(String.format("Message sent -> %s", data.toString())); // här loggar vi meddelandet
        Message<User> message =     // Message is used to send the JSON data to the Kafka topic

                MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "javaJsonGuides").build();   // Message is used to send the JSON data to the Kafka topic
        kafkaTemplate.send(message);    // KafkaTemplate is used to send the JSON data to the Kafka topic
    }
}

