package ua.edu.ukma.ykrukovska.lab1.recursion;

import acm.program.ConsoleProgram;

public class Recurrence extends ConsoleProgram {

    public void run() {

        println("Insert amount of Fibonacci numbers to be printed:");
        int amountOfFibonacciNumbers;
        do {
            amountOfFibonacciNumbers = readInt("n = ");
            if (amountOfFibonacciNumbers <= 0) {
                println("Wrong number! Amount should be positive!");
            }
        } while (amountOfFibonacciNumbers <= 0);


        int[] fibonacciNumbersRecurrent = countFibNumbersRecurrent(amountOfFibonacciNumbers);
        int[] fibonacciNumbersRecursive = calculateFibNumbersRecursive(amountOfFibonacciNumbers);

        for (int i = 0; i < amountOfFibonacciNumbers; i++) {
            println(i + " recurrent " + fibonacciNumbersRecurrent[i] + " recursive " + fibonacciNumbersRecursive[i]);
        }

        println("Insert n to count it's factorial");
        int n;
        do {
            n = readInt("n = ");
            if (n < 0) {
                println("Wrong number! Amount should be positive!");
            }
        } while (n < 0);
        println("Recursive method: n! = " + countFactorialRecursive(n));
        println("Recurrent method: n! = " + countFactorialRecurrent(n));


        println("Insert number to count it's digits");
        int number;
        do {
            number = readInt("n = ");
            if (number < 0) {
                println("Wrong number! Amount should be positive!");
            }
        } while (number < 0);
        println("amount of digits = " + countDigitsByDiv(number));

    }

    private int countDigitsByDiv(int number) {
        int i = 1;
        while (number / Math.pow(10, i) > 1) {
            i++;
        }
        return i;
    }


    private static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    private static int[] calculateFibNumbersRecursive(int amount) {
        int[] fibonacciNumbers = new int[amount];

        for (int i = 1; i < amount; i++) {
            fibonacciNumbers[i] = fibonacci(i);

        }
        return fibonacciNumbers;
    }

    private static int[] countFibNumbersRecurrent(int amount) {
        int[] fibonacciNumbers = new int[amount];
        fibonacciNumbers[1] = 1;
        for (int j = 2; j < amount; j++) {
            long result = (long) fibonacciNumbers[j - 1] + (long) fibonacciNumbers[j - 2];
            if (result <= Integer.MAX_VALUE) {
                fibonacciNumbers[j] = (int) result;
            } else {
                break;
            }
        }
        return fibonacciNumbers;
    }

    private static long countFactorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * countFactorialRecursive(n - 1);
    }

    private static long countFactorialRecurrent(int n) {
        long factorial = 1;
        for (int i = n; i >= 1; i--) {
            factorial = i * factorial;

        }
        return factorial;

    }

}