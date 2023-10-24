package Aram.kafka.Kafka;

import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class KafkaConsumer { // KafkaConsumer class is used to consume the JSON data from the Kafka topic


        private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);  // Logger is used to log the messages

        @KafkaListener(topics = "javaGuides", groupId = "myGroup")  // @KafkaListener annotation is used to consume the JSON data from the Kafka topic
        public void consume(String message) {   // consume() method is used to consume the JSON data from the Kafka topic
            LOGGER.info(String.format("Message received -> %s", message));
        }   // Logger is used to log the messages
}
