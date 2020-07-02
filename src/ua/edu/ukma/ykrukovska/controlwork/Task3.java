package ua.edu.ukma.ykrukovska.controlwork;

import acm.program.ConsoleProgram;

public class Task3 extends ConsoleProgram {

    private static final int X0 = 0;
    private static final int X1 = 9;
    private static final int K = 5;
    private static double x;
    private static int n;

    public void run() {

        calculate();
        println("x = " + x);
    }

    private double calculate() {
        for (int n = 0; n <= K; n++) {
            x = 2 * calculateSeries(n - 1) + 3 * calculateSeries(n - 2);
        }
        return x;
    }

    private double calculateSeries(int n) {
        double x = 0;
        for (n = 0; n <= K; n++) {
            x = x + 2 * calculateSeries(n - 1) + 3 * calculateSeries(n - 2);
            System.out.println("x = " + x);
        }
        return x;
    }

}
