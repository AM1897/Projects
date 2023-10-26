package org.campusmolndal.Challenge;

import org.json.JSONObject;

public class City4casting {     // klass för att hantera data från API
    private String name;        // namn på staden
    private double temp;        // temperatur i staden
    private String weatherDescription;      // väderbeskrivning i staden

    public City4casting (String name, double temp, String weatherDescription) {    // konstruktor
        this.name = name;       // sätter värden på attribut
        this.temp = temp;
        this.weatherDescription = weatherDescription;
    }

    public String getName() {           // getters
        if (name == null)               // kollar om namnet är null
            throw new NullPointerException("City name is null");        // kastar exception
        if(name.isEmpty())                              // kollar om namnet är tomt
            throw new IllegalArgumentException("City name is empty");   // kastar exception
        return name;            // returnerar namnet
    }

    public double getTemp() {       // getters
        return temp;                // returnerar temperaturen
    }

    public String getWeatherDescription() {     // getters
        return weatherDescription;              // returnerar väderbeskrivningen
    }
    static City4casting fromJson(String json){      // metod för att skapa ett objekt från en json-sträng
        JSONObject object = new JSONObject(json);   // skapar ett json-objekt
        return new City4casting(object.getString("name"),   // skapar ett objekt med värden från json-objektet
                object.getJSONObject("main").getDouble("temp"), // hämtar temperaturen från json-objektet
                object.getJSONArray("weather").getJSONObject(0).getString("description"));
    }
}
