package com.example.calculator212;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")

public class CalcController {
    private CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @RequestMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongArgumentException.class)
    public String handleException(WrongArgumentException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public String handleException(NullPointerException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @RequestMapping("/plus")
    public String sum(@RequestParam Integer num1, Integer num2) {
        return calcService.sum(num1, num2);
    }

    @RequestMapping("/minus")
    public String minus(@RequestParam Integer num1, Integer num2) {
        return calcService.minus(num1, num2);
    }

    @RequestMapping("/multiply")
    public String multiply(@RequestParam Integer num1, Integer num2) {
        return calcService.multiply(num1, num2);
    }

    @RequestMapping("/divide")
    public String divide(@RequestParam Integer num1, Integer num2) {
        return calcService.divide(num1, num2);
    }
}
