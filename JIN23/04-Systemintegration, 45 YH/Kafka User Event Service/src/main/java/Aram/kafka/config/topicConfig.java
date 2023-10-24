package Aram.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class topicConfig { // denna klass skapar topics
        @Bean
        public NewTopic myTopic(){  // skapar en topic med namn javaGuides
            return TopicBuilder.name("javaGuides").build(); // skapar en topic med namn javaGuides
        }

        @Bean
        public NewTopic myJsonTopic(){  // skapar en topic med namn javaJsonGuides
            return TopicBuilder.name("javaJsonGuides").build(); // skapar en topic med namn javaJsonGuides
        }
}
