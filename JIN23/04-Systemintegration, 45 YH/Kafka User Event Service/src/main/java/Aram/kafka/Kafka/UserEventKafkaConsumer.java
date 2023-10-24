package Aram.kafka.Kafka;

import Aram.kafka.Repository.UserRepository;
import Aram.kafka.payload.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserEventKafkaConsumer { // Kafka Consumer
	private static final Logger LOGGER = LoggerFactory.getLogger(UserEventKafkaConsumer.class);

	@Autowired
	private UserRepository userRepository; //här skapas en instans av UserRepository

	@KafkaListener(topics = "javaJsonGuides", groupId = "myGroup") //lyssnar på topic "javaJsonGuides" och groupId "myGroup"
	public void consume(User user) {	//tar emot ett User-objekt
		LOGGER.info(String.format("Json message recieved -> %s", user.toString()));	//skriver ut meddelandet i loggen
	}
}
