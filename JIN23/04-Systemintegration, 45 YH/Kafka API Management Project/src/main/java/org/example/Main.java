package org.example;

import Aram.kafka.payload.User;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class Main {
	public static void main(String[] args) throws MalformedURLException, org.json.simple.parser.ParseException {
		Menu.userMenu();

		User user = new User();

		user.setId(10L);
		user.setFirstName("Maxim");
		user.setLastName("Escobar");

		JSONObject obj = new JSONObject();
		obj.put("id", user.getId());
		obj.put("firstName", user.getFirstName());
		obj.put("lastName", user.getLastName());

		WebAPIManager.sendToWebAPI(obj);
	}
}
