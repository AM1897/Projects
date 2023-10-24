package se.dsve;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
    private Motorcycle motorcycle;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("Brand", "Model", 100, 2000, true, 5.0);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        motorcycle = null;
        System.setOut(System.out);
    }

    @Test
    void getBrand() {
        assertEquals("Brand", motorcycle.getBrand());
    }

    @Test
    void getModel() {
        assertEquals("Model", motorcycle.getModel());
    }

    @Test
    void getMaxSpeed() {
        assertEquals(100, motorcycle.getMaxSpeed());
    }

    @Test
    void getYear() {
        assertEquals(2000, motorcycle.getYear());
    }

    @Test
    void getFuelEfficiency() {
        assertEquals(5.0, motorcycle.getFuelEfficiency(), 0.01);
    }

    @Test
    void getFuelConsumption() {
        double distance = 100;
        assertEquals(5.0, motorcycle.getFuelConsumption(distance), 0.01);  // Tredje parametern är en delta för att hantera flyttal
    }

    @Test
    void printDetails() {
        motorcycle.printDetails(200, 19.42);

        // Antag att printDetails skriver ut brand, modell och år. Modifiera detta om det inte stämmer.
        String expectedOutput = "Brand Model (2000)";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void hasWindShield() {
        assertTrue(motorcycle.hasWindShield());
    }
}
