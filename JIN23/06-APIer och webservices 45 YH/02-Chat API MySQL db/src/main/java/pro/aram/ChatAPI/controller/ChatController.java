package pro.aram.ChatAPI.controller;

import org.springframework.web.bind.annotation.*;
import pro.aram.ChatAPI.Entity.Message;

import static java.lang.String.*;

@RestController
@RequestMapping("/messages")
public class ChatController {

	private String messageLog = "Hello world, first message";

	@GetMapping("/getMessage")
	public String getMessage() {
		return messageLog;
	}
	@RequestMapping("/postMessage/{message}")
	public String postMessage(@PathVariable String message) {
		messageLog += format("\n%s", message);
		return "Message Received " + message;
	}
	@PostMapping("/postMessage")
	public String postMessagePayload(
			@RequestBody Message message) {

		messageLog += format("\n%s; %s", message.Author(), message.message());
		return "Message Received " + message.message();
	}
}