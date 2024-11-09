package com.example.testingTutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    Calculator c = new Calculator();

    @Test
    public void testAdd_When_nums_are_positive() {
        int a = 5;
        int b = 10;
        int expectedOutput = 15;
        int actualOutput = c.add(a,b);
        Assertions.assertEquals(expectedOutput,actualOutput);
    }
}
