package pro.aram.ChatAPI.controller;

import org.springframework.web.bind.annotation.*;
import pro.aram.ChatAPI.Entity.Numbers;

@RestController
@RequestMapping("/number")
public class NumberController {

	private int intAntalCalls = 0;

	@GetMapping("")
	public String addCall() {
		intAntalCalls++;
		return "Du gjorde anrop nr " + intAntalCalls;
	}

	@PostMapping("")
	public String sunOfSomeDigits(
			@RequestBody Numbers numbers
	) {
		int sum = 0;

		for (int i : numbers.numbers()) {
			sum += i;
		}
		return "Summan är " + sum;
	}
}
