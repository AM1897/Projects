package org.campusmolndal.Challenge;

import java.io.IOException;

public class WeatherService {
    private WeatherAPI weatherAPI;
    private City4casting cityInfo;

    public WeatherService(WeatherAPI weatherAPI, String cityName) throws IOException {
        this.weatherAPI = weatherAPI;       // sätter värden på attribut
        String jsonWeatherInfo = this.weatherAPI.getWeatherInformation(cityName); // hämtar väderinformation från API
        this.cityInfo = City4casting.fromJson(jsonWeatherInfo); // skapar ett City4casting-objekt från väderinformationen
    }

    public String getCityName() {
        return cityInfo.getName();
    }

    public double getCityTemp() {
        return cityInfo.getTemp();
    }

    public String getCityWeatherDescription() {
        return cityInfo.getWeatherDescription();
    }
}
