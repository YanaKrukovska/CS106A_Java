package ua.edu.ukma.ykrukovska.lab1.recursion;

import acm.program.ConsoleProgram;

public class CosCalculator extends ConsoleProgram {

    private static double X;
    private static double EP;

    public void run() {

        int userInput;
        do {
            EP = readDouble("EP = ");
            do {
                X = readDouble("X = ");
                if (X < -Math.PI / 4 || X > Math.PI / 4) {
                    println("Wrong number! It should be -pi/4 =< X <= pi/4");
                }
            } while (!(X >= -Math.PI / 4 && X <= Math.PI / 4));

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
        } while (Math.abs(sn1 - sn0) > EP);
        println("Recurrent: cos(x) = " + calculateSeriesRecurrent(n));

    }

    private void testRecursiveCalculation() {
        double sn1;
        double sn0;
        int n = 3;
        do {
            sn1 = calculateRecursive(n);
            sn0 = calculateRecursive(n - 1);
            n++;
        } while (Math.abs(sn1 - sn0) > EP);
        println("Recursive: cos(x) = " + calculateRecursive(n));

    }

    private double calculateSeriesRecurrent(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result = result + calculateSeriesMember(i);
        }
        return result;
    }

    public double calculateRecursive(int n) {
        double result = 0;
        if (n == 0) {
            return 1;
        }
        result += calculateSeriesMember(n) + calculateRecursive(n - 1);

        return result;
    }

    private double calculateSeriesMember(int n) {
        return Math.pow(-1, n) * Math.pow(X, 2 * n) / factorial(2 * n);

    }

    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
