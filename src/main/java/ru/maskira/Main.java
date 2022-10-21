package ru.maskira;

import java.io.IOException;

public class Main {

    // строитель, команда, цепочка обязанностей
    public static void main(String[] args) throws IOException {
        System.out.println("Дробные значения через точку. Калькулятор поддерживает следующие (бинарные!) операции:" +
                "\n сложение +" +
                "\nвычитание -" +
                "\nумножние *" +
                "\nделение \\ или /");
        while (true){
            String expression = main.java.ru.maskira.Input.getInput();
            Calculator calculator = new Calculator(expression);
            Number number = calculator.getResult();
            System.out.println(number.doubleValue());
        }
    }
}
