package com.example.calculator212;

import org.springframework.stereotype.Service;

@Service

public class CalcServiceImpl implements CalcService{
    public String sum(Integer num1, Integer num2) {
        validation(num1, num2);
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    public String minus(Integer num1, Integer num2) {
        validation(num1, num2);
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    public String multiply(Integer num1, Integer num2) {
        validation(num1, num2);
        return num1 + " * " + num2 + " = " + num1 * num2;
    }

    public String divide(Integer num1, Integer num2) {
        validation(num1, num2);
        if (num2 == 0) {
            throw new WrongArgumentException("Делить на ноль нельзя!");
        }

        return num1 + " / " + num2 + " = " + num1 / num2;
    }

    private void validation(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NullPointerException("Не введен один из параметров");
        }
    }
}
