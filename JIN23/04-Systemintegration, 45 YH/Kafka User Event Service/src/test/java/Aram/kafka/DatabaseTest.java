package Aram.kafka;

import Aram.kafka.Repository.UserRepository;
import Aram.kafka.payload.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTest {

	@Autowired
	private UserRepository userRepository;


	static User testUser;

	@BeforeEach
	void setUp() {
		System.out.println("Before test");
	}

	@AfterEach
	void tearDown() {
		System.out.println("After test");
	}

	@Test
	@Order(1)
	void createUser() {
		//Skapa ett objekt av User med specifika data
		User user = new User();
		user.setFirstName("Samaher");
		user.setLastName("El daba");

		//Spara objektet i databasen
		testUser = userRepository.save(user);

		assertNotNull(userRepository.findById(testUser.getId()).get().getFirstName()); //Kolla om det finns i databasen
		System.out.println(testUser.getId());
	}

	@Test
	@Order(2)
	void updateUser() {
		//hämta User med id 1
		User fetchedUser = userRepository.findById(testUser.getId()).get();
		assertNotNull(fetchedUser);

		//Uppdatera User
		fetchedUser.setFirstName("Aram");
		userRepository.save(fetchedUser);
		assertEquals("Aram", userRepository.findById(testUser.getId()).get().getFirstName());
	}

	@Test
	@Order(3)
	void removeUser() {
		//kontrollera om User med id 1 finns
		assertNotNull(userRepository.findById(testUser.getId()).get());

		//Ta bort User med id 1 och kontrollera om det är borttaget
		userRepository.deleteById(testUser.getId());
		assertTrue(userRepository.findById(testUser.getId()).isEmpty());
	}
}
