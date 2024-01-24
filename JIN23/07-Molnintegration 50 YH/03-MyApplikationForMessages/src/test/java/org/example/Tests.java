package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void TestingMain() {
        Main main1 = new Main();
        Main main2 = new Main();

        assertEquals(main1.add(), main2.add());
    }

    @Test
    public void TestingAdd() {
        Main main = new Main();

        assertEquals(main.add(), 10);
    }
}
