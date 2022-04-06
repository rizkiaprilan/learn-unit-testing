package com.example.learnjunit.b_assertions_and_assumptions;

import com.example.learnjunit.model.Address;
import com.example.learnjunit.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsAndAssumptionsTest {

    User user;
    Address address;

    @BeforeEach
    void setUp() {
        user = new User();
        address = new Address("John", "User");
    }

    @Test
    void exceptionTesting() {
        // set up user
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Age must be an Integer.");
        });
        assertEquals("Age must be an Integer.", exception.getMessage());
    }

    @Test
    void assertTrueTesting() {
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        assertAll("address name",
                () -> assertEquals("John", address.getFirstName()),
                () -> assertEquals("User", address.getLastName())
        );
    }



}
