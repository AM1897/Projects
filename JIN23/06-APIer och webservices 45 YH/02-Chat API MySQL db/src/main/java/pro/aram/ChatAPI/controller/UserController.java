package pro.aram.ChatAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.aram.ChatAPI.Entity.User;
import pro.aram.ChatAPI.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("")
	private String saveUser(
			@RequestBody User user
	) {
		User newUser = userService.saveUser(user);
		return String.format("Ny användare skapad med namn %s och ID nummer %d", newUser.getUserName(), newUser.getId());
	}

	@GetMapping("")
	private String loadUsers() {
		List<User> users = userService.loadUser();

		String response = "Namnen på alla användare är: ";

		for (User user : users) {
			response += user.getUserName() + ", ";
		}
		return response;
	}

	@GetMapping("/{id")
	private String loadUser(
			@PathVariable Long id
	) {
		User user = userService.loadOneUser(id);
		return String.format("Användare %s har ID %d", user.getUserName(), user.getId());
	}
}
