package ua.edu.ukma.ykrukovska.unit7;

import acm.program.ConsoleProgram;

/* Task: count fibonacci numbers and show one less than user's input.
 * Made by: Yana Krukovska
 * ua.edu.ukma.ykrukovska.unit7.FibonacciLimitedCounter.java
 * */
public class FibonacciLimitedCounter extends ConsoleProgram {

    public void run() {
        int userInput;

        do {
            println("Insert amount of Fibonacci numbers to be printed:");
            int amountOfFibonacciNumbers;
            do {
                amountOfFibonacciNumbers = readInt("n = ");
                if (amountOfFibonacciNumbers <= 0) {
                    println("Wrong number! Amount should be positive!");
                }
            } while (amountOfFibonacciNumbers <= 0);

            int[] fibonacciNumbersRecursive = calculateFibNumbersRecursive(amountOfFibonacciNumbers - 1);

            if (amountOfFibonacciNumbers == 1) {
                println("You chose not to show any fibonacci numbers!");
            }
            for (int i = 0; i < amountOfFibonacciNumbers - 1; i++) {
                println(i + "-" + fibonacciNumbersRecursive[i]);
            }
            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();
        } while (userInput != 0);

    }

    // Calculates fibonacci numbers using recursive method.
    private static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    // Calculates Fibonacci numbers using recursive method.
    private static int[] calculateFibNumbersRecursive(int amount) {
        int[] fibonacciNumbers = new int[amount];

        for (int i = 1; i < amount; i++) {
            fibonacciNumbers[i] = fibonacci(i);

        }
        return fibonacciNumbers;
    }

}
