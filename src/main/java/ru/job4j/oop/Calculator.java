package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int f) {
        return f / x;
    }

    public int sumAllOperation(int sumAll) {
        return sum(sumAll) + multiply(sumAll) + minus(sumAll) + divide(sumAll);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);

        int sub = minus(16);
        System.out.println(sub);

        int div = calculator.divide(20);
        System.out.println(div);

        int sumAll = calculator.sumAllOperation(12);
        System.out.println(sumAll);
    }
}
