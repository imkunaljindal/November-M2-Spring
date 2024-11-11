package com.example.testingTutorial;

import org.junit.jupiter.api.*;

public class CalculatorTests {

    Calculator c = new Calculator();

    @BeforeAll
    public static void beforeEntireTestClass() {
        System.out.println("Executed before the class");
    }

    @AfterAll
    public static void afterEntireClass() {
        System.out.println("Executed after the class");
    }

    @BeforeEach
    public void initializeBeforeEveryTest() {
        System.out.println("This is executed before every test");
    }

    @AfterEach
    public void afterEveryTestCase() {
        System.out.println("This is executed after every test");
    }

    @Test
    @DisplayName("This is a test case for add when input is even")
    public void testAdd_When_nums_are_positive() {
        System.out.println("Test 1");
        int a = 5;
        int b = 10;
        int expectedOutput = 15;
        int actualOutput = c.add(a,b);
        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testIsEven_When_Input_is_Even() {
        System.out.println("Test 2");
        int x = 10;
        boolean actual = c.isEven(x);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testIsEven_When_Input_Is_Odd() {
        System.out.println("Test 3");
        int x = 11;
        boolean actual = c.isEven(x);
        Assertions.assertFalse(actual);
    }
}
