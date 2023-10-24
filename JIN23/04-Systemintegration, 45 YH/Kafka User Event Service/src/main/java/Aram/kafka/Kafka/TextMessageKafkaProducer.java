package Aram.kafka.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class TextMessageKafkaProducer { //vi skapar en klass som ska skicka meddelanden till kafka

	private KafkaTemplate<String, String> kafkaTemplate;	//här skickar vi meddelanden till kafka
	private static final Logger LOGGER = LoggerFactory.getLogger(TextMessageKafkaProducer.class);

	//constructor
	public TextMessageKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) { //vi skickar med kafkaTemplate som parameter
		this.kafkaTemplate = kafkaTemplate;	//vi sätter vår lokala variabel till den som skickas med
	}

	public void sendMessage(String message) { 		//vi skickar meddelandet till kafka
		kafkaTemplate.send("javaGuides", message);	//vi skickar meddelandet till topic "javaGuides"
		LOGGER.info(String.format("Message sent: %s", message));	//vi loggar att meddelandet har skickats
	}
}