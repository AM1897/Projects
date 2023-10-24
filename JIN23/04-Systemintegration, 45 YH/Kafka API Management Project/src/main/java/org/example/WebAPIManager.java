package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import java.io.IOException;

public class WebAPIManager {


	// Skapa ny användare
	public static void sendToWebAPI(JSONObject obj) {
		sendJsonToEndpoint(obj, "http://localhost:8080/api/v1/kafka/publish", "POST");
	}

	// Uppdatera användare
	public static void updateUserInWebAPI(Long id, JSONObject obj) {
		sendJsonToEndpoint(obj, "http://localhost:8080/api/v1/kafka/update/" + id, "PUT");
	}

	// Ta bort användare
	public static void deleteUserFromWebAPI(Long id) {
		sendToEndpoint("http://localhost:8080/api/v1/kafka/delete/" + id, "DELETE");
	}

	// Visa användare
	public static void readUserFromWebAPI(Long id) {
		sendToEndpoint("http://localhost:8080/api/v1/kafka/get/" + id, "GET");
		returnResponse("-----Användare med denna id finns inte i db-----");
	}

	private static void sendJsonToEndpoint(JSONObject obj, String endpoint, String method) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			String jsonPayload = obj.toJSONString();
			StringEntity entity = new StringEntity(jsonPayload, ContentType.APPLICATION_JSON);

			CloseableHttpResponse response;
			switch(method) {
				case "POST":
					HttpPost httpPost = new HttpPost(endpoint);
					httpPost.setEntity(entity);
					response = httpClient.execute(httpPost);
					break;
				case "PUT":
					HttpPut httpPut = new HttpPut(endpoint);
					httpPut.setEntity(entity);
					response = httpClient.execute(httpPut);
					break;
				default:
					throw new UnsupportedOperationException("Unsupported method: " + method);
			}

			processResponse(response);

		} catch (IOException e) {
			e.printStackTrace();
			returnResponse("Något gick fel");
		}
	}

	private static void sendToEndpoint(String endpoint, String method) {
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

			CloseableHttpResponse response;
			switch(method) {
				case "GET":
					HttpGet httpGet = new HttpGet(endpoint);
					response = httpClient.execute(httpGet);
					break;
				case "DELETE":
					HttpDelete httpDelete = new HttpDelete(endpoint);
					response = httpClient.execute(httpDelete);
					break;
				default:
					throw new UnsupportedOperationException("Unsupported method: " + method);
			}

			processResponse(response);

		} catch (IOException e) {
			e.printStackTrace();
			returnResponse("Något gick fel");
		}
	}

	private static void processResponse(CloseableHttpResponse response) throws IOException {
		HttpEntity responseEntity = response.getEntity();
		if (responseEntity != null) {
			String responseString = EntityUtils.toString(responseEntity);
			System.out.println("Svar från server: " + responseString);
			returnResponse(responseString);
		}
	}

	public static void returnResponse(String message) {
		System.out.println(message);
	}
}
