package se.dsve;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Truck truck;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        truck = new Truck("Brand", "Model", 100, 2000, 2, 5000, 10.0);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        truck = null;
        System.setOut(System.out);
    }

    @Test
    void getBrand() {
        assertEquals("Brand", truck.getBrand());
    }

    @Test
    void getModel() {
        assertEquals("Model", truck.getModel());
    }

    @Test
    void getMaxSpeed() {
        assertEquals(100, truck.getMaxSpeed());
    }

    @Test
    void getYear() {
        assertEquals(2000, truck.getYear());
    }

    @Test
    void getFuelEfficiency() {
        assertEquals(10.0, truck.getFuelEfficiency(), 0.01);
    }

    @Test
    void getFuelConsumption() {
        double distance = 100;
        assertEquals(10.0, truck.getFuelConsumption(distance), 0.01);  // Tredje parametern är en delta för att hantera flyttal
    }

    @Test
    void printDetails() {
        truck.printDetails(200, 19.42);

        // Antag att printDetails skriver ut brand, modell och år. Modifiera detta om det inte stämmer.
        String expectedOutput = "Brand Model (2000)";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void getDoors() {
        assertEquals(2, truck.getDoors());
    }

    @Test
    void getCapacity() {
        assertEquals(5000, truck.getCapacity());
    }
}
