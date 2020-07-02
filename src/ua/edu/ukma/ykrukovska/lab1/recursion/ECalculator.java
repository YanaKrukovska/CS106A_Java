package ua.edu.ukma.ykrukovska.lab1.recursion;

import acm.program.ConsoleProgram;

public class ECalculator extends ConsoleProgram {

    private static double X;
    private static double ep;

    public void run() {
        int userInput;
        do {
            ep = readDouble("ep = ");

            do {
                X = readDouble("X = ");
                if (X < 0 || X >= 1) {
                    println("Wrong number! It should be 0 =< X < 1");
                }
            } while (!(X >= 0 && X < 1));

            testRecurrentCalculation();
            testRecursiveCalculation();

            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();
        } while (userInput != 0);
    }

    private void testRecurrentCalculation() {
        double sn1;
        double sn0;

        int n = 3;
        do {
            sn1 = calculateSeriesRecurrent(n);
            sn0 = calculateSeriesRecurrent(n - 1);

            n++;
        } while (Math.abs(sn1 - sn0) > ep);

        println("Recurrent: e^x = " + calculateSeriesRecurrent(n));

    }

    private void testRecursiveCalculation() {
        double sn1;
        double sn0;
        int n = 3;
        do {
            sn1 = calculateRecursive(n);
            sn0 = calculateRecursive(n - 1);
            n++;
        } while (Math.abs(sn1 - sn0) > ep);
        println("Recursive: e^x = " + calculateRecursive(n));


    }

    private double calculateSeriesRecurrent(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result = result + calculateSeriesMember(i);
        }
        return result;
    }

    private double calculateRecursive(int n) {
        double result = 0;
        if (n == 0) {
            return 1;
        }
        result += calculateSeriesMember(n) + calculateRecursive(n - 1);

        return result;
    }

    private double calculateSeriesMember(int n) {
        return Math.pow(X, n) / factorial(n);

    }

    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
