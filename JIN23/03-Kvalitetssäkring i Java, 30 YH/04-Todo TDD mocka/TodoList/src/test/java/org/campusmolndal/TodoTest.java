package org.campusmolndal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {
    private Todo todo;

    @BeforeEach
    void setUp() {
        // Skapa ett Todo-objekt innan varje testmetod körs
        todo = new Todo("John Doe", "Gör inköp");
    }

    @AfterEach
    void tearDown() {
        // Rensa upp efter varje testmetod
        todo = null;
    }

    @Test
    void getName() {
        // Kontrollera att getName() returnerar rätt namn
        assertEquals("John Doe", todo.getName());
    }

    @Test
    void getTodo() {
        // Kontrollera att getTodo() returnerar rätt att göra-uppgift
        assertEquals("Gör inköp", todo.getTodo());
    }
}
