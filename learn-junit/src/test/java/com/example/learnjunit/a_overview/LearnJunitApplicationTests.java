package com.example.learnjunit.a_overview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LearnJunitApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

}
