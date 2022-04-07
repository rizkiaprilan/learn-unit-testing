package com.example.learnjunit.c_dynamic_and_parameterized;

import com.example.learnjunit.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicAndParameterizedTests {

    Calculator calculator;

    public static int[][] getData() {
        return new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @TestFactory
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        int[][] data = new int[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return DynamicTest.dynamicTest(String.format("%d * %d = %d", m1, m2, expected), () -> {
                assertEquals(expected, calculator.multiply(m1, m2));
            });
        });
    }

    @ParameterizedTest
    @MethodSource(value = "getData")
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }

}
