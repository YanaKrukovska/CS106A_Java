package ua.edu.ukma.ykrukovska.unit6;

import acm.program.ConsoleProgram;

import java.awt.*;

public class QuadraticEquations extends ConsoleProgram {

    private static final double END = -999;

    public void run() {
        getConsole().setFont(new Font("Comic Sans MS", Font.TRUETYPE_FONT, 15));

        while (true) {
            double a = readDouble("a: ");
            double b = readDouble("b: ");
            double c = readDouble("c: ");
            double d = readDouble("d: ");
            double x = readDouble("x: ");
            double y = readDouble("y:");

            if (a == END || b == END || c == END || d == END || x == END || y == END)
                break;

            println("biggest number = " + max(a, b, c, d));
            println("x^4 = " + fourthDegree(x));
            println("Quadratic equation value = " + quadraticEquation(a, b, c, x));
            println("y^1/4 = " + Math.pow(y, 0.25));
            solveQuadraticEquation(a, b, c, y);
            println("(y - c)/ a = " + (double) ((y - c) / a));
        }
    }

    double fourthDegree(double x) {
        return Math.pow(x, 4);
    }

    double quadraticEquation(double a, double b, double c, double x) {
        return a * Math.pow(x, 2) + b * x + c;
    }

    double max(double a, double b, double c, double d) {
        if (a > b && a > c && a > d)
            return a;

        else if (b > a && b > c && b > d)
            return b;

        else if (c > a && c > b && c > d)
            return c;

        else
            return d;
    }

    private void solveQuadraticEquation(double a, double b, double c, double y) {
        double discriminant = calculateDiscriminant(a, b, c, y);
        if (discriminant < 0) {
            println("No solution");
        } else if (discriminant == 0) {
            double x0 = -b / 2 * a;
            println("One solution:" + x0);
        } else if (discriminant > 0) {
            double x1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
            double x2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            println("Result:" + "  1) " + x1 + "  2) " + x2);
        }
    }

    private double calculateDiscriminant(double a, double b, double c, double y) {
        return Math.pow(b, 2) - 4 * a * (c - y);
    }

}