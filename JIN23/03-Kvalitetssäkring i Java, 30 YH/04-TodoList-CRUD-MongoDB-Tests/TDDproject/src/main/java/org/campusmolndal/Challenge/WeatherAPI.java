package org.campusmolndal.Challenge;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI {       // klass för att hantera data från API

    private final String apiKey;        // API-nyckel

    public WeatherAPI(String apiKey) {
        this.apiKey = apiKey;
    }   // konstruktor

    public String getWeatherInformation(String city) throws IOException {   // metod för att hämta väderinformation från API
        String baseUrl = "https://api.example.com/weather";     // bas-url för API
        String url = baseUrl + "?q=" + city + "&appid=" + apiKey;   // url för API-anrop
        URL apiUrl = new URL(url);      // skapar ett URL-objekt
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();   // skapar en anslutning till API
        conn.setRequestMethod("GET");       // sätter anslutningens metod till GET

        int responseCode = conn.getResponseCode();      // hämtar svarskod från anslutningen
        if (responseCode == 200) {          // kollar om svarskoden är 200
            Scanner scanner = new Scanner(conn.getInputStream());       // skapar en scanner för att läsa in data från anslutningen
            StringBuilder response = new StringBuilder();       // skapar en StringBuilder för att bygga upp ett svar
            while (scanner.hasNextLine()) {         // loopar igenom alla rader i anslutningens svar
                response.append(scanner.nextLine());        //  lägger till raden i StringBuilder
            }
            scanner.close();
            return response.toString();

        } else {
            throw new IOException("Ogiltig stad");      // kastar exception om svarskoden inte är 200
        }
    }
}
