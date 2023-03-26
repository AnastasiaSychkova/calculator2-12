package com.example.calculator212;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceTest {
    @Autowired
    private CalcService calcService;

    @Test
    void plus_success() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "3 + 4 = 7";
        String expectedResult = answer;

        //Начало теста
        String actualResult = calcService.sum(num1, num2);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void minus_success() {
        //Подготовка входных данных
        Integer num1 = 5;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "5 - 4 = 1";
        String expectedResult = answer;

        //Начало теста
        String actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void minus_negativeResult() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "3 - 4 = -1";
        String expectedResult = answer;

        //Начало теста
        String actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void multiply_success() {
        //Подготовка входных данных
        Integer num1 = 3;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "3 * 4 = 12";
        String expectedResult = answer;

        //Начало теста
        String actualResult = calcService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_success() {
        //Подготовка входных данных
        Integer num1 = 12;
        Integer num2 = 4;

        //Подготовка ожидаемого результата
        String answer = "12 / 4 = 3";
        String expectedResult = answer;

        //Начало теста
        String actualResult = calcService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_withWrongArgumentException() {
        //Подготовка входных данных
        Integer num1 = 12;
        Integer num2 = 0;

        //Подготовка ожидаемого результата
        Exception exception = assertThrows(
                WrongArgumentException.class,
                () -> {
                    calcService.divide(num1, num2);
                }
        );
        String expectedMessage = "Делить на ноль нельзя!";

        //Начало теста
        assertEquals(expectedMessage, exception.getMessage());
    }

}