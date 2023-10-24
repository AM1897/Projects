package se.dsve;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Vehicle vehicle;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        vehicle = new TestVehicle("Brand", "Model", 100, 2000, 5.0);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        vehicle = null;
        System.setOut(System.out);
    }

    @Test
    void getBrand() {
        assertEquals("Brand", vehicle.getBrand());
    }

    @Test
    void getModel() {
        assertEquals("Model", vehicle.getModel());
    }

    @Test
    void getMaxSpeed() {
        assertEquals(100, vehicle.getMaxSpeed());
    }

    @Test
    void getYear() {
        assertEquals(2000, vehicle.getYear());
    }

    @Test
    void getFuelEfficiency() {
        assertEquals(5.0, vehicle.getFuelEfficiency(), 0.01);
    }

    @Test
    void getFuelConsumption() {
        double distance = 100;
        assertEquals(5.0, vehicle.getFuelConsumption(distance), 0.01);
    }


    @Test
    void printDetails() {
        vehicle.printDetails(200, 19.42);
        String expectedOutput = "Brand Model (2000)";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    class TestVehicle extends Vehicle {
        public TestVehicle(String brand, String model, int speed, int year, double fuelConsumption) {
            super(brand, model, speed, year, fuelConsumption);
        }
    }
}
