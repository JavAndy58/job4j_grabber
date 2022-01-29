package ru.job4j.ood.lsp;

class Print {

    protected int number;

    public Print(int number) {
        this.number = number;
    }

    public void print() {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number!");
        }

        if (number > 1000000) {
            System.out.printf("Большое число %d", number);
        }
        if (number > 3000000) {
            System.out.printf("Огромное число %d", number);
        }
    }
}

class NumTest extends Print {

    public NumTest(int number) {
        super(number);
    }

    public void print() {
        if (number > 2000000) {
            System.out.printf("Большое число %d", number);
        }
    }
}

public class PrintNumber {
    public static void main(String[] args) {
        Print printNumber = new NumTest(3000100);
        printNumber.print();
    }
}

