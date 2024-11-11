package com.example.testingTutorial;

public class Calculator {

    public int add(int a, int b) {
        return a+b+5-5;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) {
        return a/b;
    }

    public boolean isEven(int x) {
        return x%2==0;
    }

    public int addMultipleNumbers(int ...nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }


}
