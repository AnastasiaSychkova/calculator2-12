package com.example.calculator212;

public class ResultGenerator {

    public static String plusResult(Integer num1, Integer num2, Integer result) {
        return String.format("%s + %s = %s", num1, num2, result);
    }

    public static String minusResult(Integer num1, Integer num2, Integer result) {
        return String.format("%s - %s = %s", num1, num2, result);
    }

    public static String multiplyResult(Integer num1, Integer num2, Integer result) {
        return String.format("%s * %s = %s", num1, num2, result);
    }

    public static String divideResult(Integer num1, Integer num2, Double result) {
        return String.format("%s : %s = %s", num1, num2, result);
    }
}
