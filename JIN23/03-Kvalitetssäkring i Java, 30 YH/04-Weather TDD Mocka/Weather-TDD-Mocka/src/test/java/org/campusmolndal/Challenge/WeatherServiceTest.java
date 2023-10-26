package org.campusmolndal.Challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {      // klass för att testa WeatherService

    @Mock
    WeatherAPI mockWeatherAPI;      // mock-objekt för WeatherAPI

    WeatherService weatherService;      // objekt för WeatherService

    @BeforeEach
    void setUp() throws IOException {       // metod som körs innan varje test
        mockWeatherAPI = Mockito.mock(WeatherAPI.class);        // skapar mock-objekt för WeatherAPI

        // mockar ett svar från API
        String mockResponse = """
        {
          "main": {
            "temp": 20.59
          },
          "name": "Miami",
          "weather": [
            {
              "description": "overcast clouds"
            }
          ]
        }\s""";



        Mockito.when(mockWeatherAPI.getWeatherInformation("Miami")).thenReturn(mockResponse);      // mockar ett svar från API
        weatherService = new WeatherService(mockWeatherAPI, "Miami");      // skapar ett objekt för WeatherService
    }
    @Test
    @DisplayName("Test 1, Kontrollera om stadens namn är korrekt.")        // test för att kolla om stadens namn är korrekt
    void getCityName() {        // metod för att testa stadens namn
        String expectedName = "Miami";     // förväntat namn
        String actualName = weatherService.getCityName();
        assertEquals(expectedName, actualName);
    }
    @Test
    @DisplayName("Test 2, Kontrollera om stadens temperatur är korrekt.")     // test för att kolla om stadens temperatur är korrekt
    void getCityTemp() {        // metod för att testa stadens temperatur
        double expectedTemp = 20.59;        // förväntad temperatur
        double actualTemp = weatherService.getCityTemp();       // faktisk temperatur
        assertEquals(expectedTemp, actualTemp, 0.008);      // kollar om förväntad temperatur är lika med faktisk temperatur
    }
    @Test
    @DisplayName("Test 3, Verifiera att väderbeskrivningen för staden är korrekt.")     // test för att kolla om stadens väderbeskrivning är korrekt
    void getCityWeatherDescription() {      // metod för att testa stadens väderbeskrivning
        String expectedDescription = "overcast clouds";     // förväntad väderbeskrivning
        String actualDescription = weatherService.getCityWeatherDescription();      // faktisk väderbeskrivning
        assertEquals(expectedDescription, actualDescription);       //  kollar om förväntad väderbeskrivning är lika med faktisk väderbeskrivning
    }
}
