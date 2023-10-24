package org.example;

import Aram.kafka.payload.User;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Menu {

	public static void userMenu() {
		String userChoice = "";

		do {
			printMenu();
			Scanner scan = new Scanner(System.in);
			userChoice = scan.nextLine();

			switch (userChoice) {
				case "1":
					createUser();
					break;
				case "2":
					updateUser();
					break;
				case "3":
					deleteUser();
					break;
				case "4":
					readUser();
					break;
				case "0":
					System.out.println("Avslutar...");
					break;
				default:
					System.out.println("Felaktig input. Försök igen");
					break;
			}

			if (!userChoice.equals("0")) {
				System.out.println("Press any key to continue...");
				scan.nextLine();
			}
		} while (!userChoice.equals("0"));
	}

	public static void printMenu() {
		System.out.println("==================================");
		System.out.println("            MENYVAL               ");
		System.out.println("==================================");
		System.out.println("1. Skapa ny användare             ");
		System.out.println("2. Uppdatera användare            ");
		System.out.println("3. Ta bort användare              ");
		System.out.println("4. Visa användare                 ");
		System.out.println("----------------------------------");
		System.out.println("0. Avsluta programmet             ");
		System.out.println("==================================");
	}

	public static void createUser() {
		User user = getUserInput();
		JSONObject obj = userToJSONObject(user);
		WebAPIManager.sendToWebAPI(obj);
	}

	public static void updateUser() {
		User user = getUserInput();
		JSONObject obj = userToJSONObject(user);
		WebAPIManager.updateUserInWebAPI(user.getId(), obj);
	}

	public static void deleteUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ange ID för användaren du vill ta bort: ");
		Long id = scanner.nextLong();
		WebAPIManager.deleteUserFromWebAPI(id);
	}

	public static void readUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ange ID för användaren du vill visa: ");
		Long id = scanner.nextLong();
		WebAPIManager.readUserFromWebAPI(id);
	}

	private static User getUserInput() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ange ID: ");
		Long id = scanner.nextLong();
		scanner.nextLine();

		System.out.print("Ange förnamn: ");
		String firstName = scanner.nextLine();

		System.out.print("Ange efternamn: ");
		String lastName = scanner.nextLine();

		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		return user;
	}

	private static JSONObject userToJSONObject(User user) {
		JSONObject obj = new JSONObject();
		obj.put("id", user.getId());
		obj.put("firstName", user.getFirstName());
		obj.put("lastName", user.getLastName());
		return obj;
	}
}
