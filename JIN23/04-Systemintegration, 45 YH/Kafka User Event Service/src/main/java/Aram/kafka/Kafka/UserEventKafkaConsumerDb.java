package Aram.kafka.Kafka;

import Aram.kafka.Repository.UserRepository;
import Aram.kafka.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventKafkaConsumerDb { // Skriver till databasen

	private final UserRepository userRepository; // Skapar en instans av UserRepository

	@Autowired
	public UserEventKafkaConsumerDb(UserRepository userRepository) { 	// här skapas en konstruktor som tar in en instans av UserRepository
		this.userRepository = userRepository;						// och sätter den till den lokala instansen
	}
	// här skapas en metod som tar in en instans av User och skriver ut den
	@KafkaListener(topics = "javaJsonGuides", groupId = "otherGroup")
	public void writeToDb(User user) {
		System.out.println(user);
		System.out.println("Skriver till databasen");
		userRepository.save(user);
	}
}

