package ru.job4j.ood.ocp;

import java.util.Random;

public class Print {

    private static class SimplePrint {
        private Random random;

        public void print(int x) {
            System.out.printf("Ввведенное число %d", x);
        }
    }

    private static class MainPrint {
        private SimplePrint simplePrint;

        public MainPrint() {
            simplePrint = new SimplePrint();
        }

        public void printNumber(int number) {
            simplePrint.print(number);
        }
    }

    public static void main(String[] args) {
        MainPrint mainPrint = new MainPrint();
        mainPrint.printNumber(100);
    }
}
