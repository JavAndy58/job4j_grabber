package ru.job4j.ood.srp;

public class CalculatorForm implements Calculator {
    private double divisionResult;

    public void division(double num1, double num2) {
        if (num2 == 0 || num1 == 0) {
            System.out.println("Введен ноль в калькулятор, поменяйте цифру");
        }
        divisionResult = num1 / num2;
        System.out.printf("Результат деления чисел %s и %s равно %s", num1, num2, divisionResult);
    }

    public static void main(String[] args) {
        CalculatorForm calculator = new CalculatorForm();
        calculator.division(4, 2.0);
    }
}
