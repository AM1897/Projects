package pro.aram.ChatAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.aram.ChatAPI.Entity.User;
import pro.aram.ChatAPI.Repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	public List<User> loadUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User loadOneUser(Long id) {

		Optional<User> user = userRepository.findById(id);
		return user.orElse(User.getUnknownUser());
	}
}
