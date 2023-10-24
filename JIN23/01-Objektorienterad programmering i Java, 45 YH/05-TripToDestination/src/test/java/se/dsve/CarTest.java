package se.dsve;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("BMW", "M5", 260, 2022, 4, 10.0);
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    void getBrand() {
        assertEquals("BMW", car.getBrand());
    }

    @Test
    void getModel() {
        assertEquals("M5", car.getModel());
    }

    @Test
    void getMaxSpeed() {
        assertEquals(260, car.getMaxSpeed());
    }

    @Test
    void getYear() {
        assertEquals(2022, car.getYear());
    }

    @Test
    void getFuelEfficiency() {
        assertEquals(10.0, car.getFuelEfficiency());
    }

    @Test
    void getFuelConsumption() {
        double distance = 100;
        assertEquals(10.0, car.getFuelConsumption(distance), 0.01);  // Tredje parametern är en delta för att hantera flyttal
    }

    @Test
    void printDetails() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        car.printDetails(200, 19.42);

        System.out.println("Actual output: " + outContent.toString());

        String expectedOutput = "BMW M5 (2022)\n" +
                "Maximum speed is 260 km/h\n" +
                "Fuel efficiency is 10.0 per 100 km\n" +
                "Fuel needed for the trip to Malmö is 20.0 liters\n" +
                "Fuel cost for the entire trip is";

        assertTrue(outContent.toString().contains(expectedOutput));

    }

    @Test
    void getDoors() {
        assertEquals(4, car.getDoors());
    }
}
