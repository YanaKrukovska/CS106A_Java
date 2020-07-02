package ua.edu.ukma.ykrukovska.controlwork;

public class Task {

    public static void main(String[] args) {
        //  System.out.println(cosinus(-5, 0.001));
        //System.out.println( Math.cos(-2));
        // System.out.println(cosinus(5, 0.001));
        System.out.println(Math.cos(1.57079632679));
    }

    private static double tan(double n, double eps) {
        return sinus(n, eps) / cosinus(n, eps);
    }

    private static double cosinus(double x, double eps) {

        int f1_0 = 1;
        double f2_0 = 1;
        long f3_0 = 1;

        int f1;
        double f2;
        long f3;

        double s = 1;
        int k = 1;
        int kf = 0;

        do {
            f1 = -f1_0;
            f2 = f2_0 * x * x;
            f3 = f3_0 * (kf + 1) * (kf + 2);
            kf = 2 * k;

            s += f1 * f2 / f3;
            f1_0 = f1;
            f2_0 = f2;
            f3_0 = f3;
            k++;
            //System.out.println(sum);
            // System.out.println("steps = " + step);
        } while (Math.abs(f1 * f2 / f3) > eps);

        return s;

    }

    private static int polynomials(int n, int x) {
        int t_two_less = 1;
        int t_one_less = x;
        int t_current = 0;

        for (int i = 2; i <= n; i++) {
            t_current = 2 * x * t_one_less - t_two_less;
            System.out.println("n" + i + " = " + t_current);
            t_two_less = t_one_less;
            t_one_less = t_current;
        }
        return t_current;
    }

    private static int divisorRecursive(int m, int n) {

        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        } else {
            return divisorRecursive(n, Math.floorMod(m, n));
        }
    }

    private static int divisorCycle(int m, int n) {

        if (m == 0) {
            return n;
        }
        if (m == n) {
            return m;
        }

        while (n != 0) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        return m;
    }

    private static double sinus(double x, double eps) {

        int f1_0 = 1;
        double f2_0 = x;
        long f3_0 = 1;

        int f1;
        double f2;
        long f3;
        double s = x;
        int k = 1;
        int kf = 1;

        do {

            f1 = -f1_0;
            f2 = f2_0 * x * x;
            f3 = f3_0 * (kf + 1) * (kf + 2);
            kf = 2 * k + 1;

            s += f1 * f2 / f3;

            f1_0 = f1;
            f2_0 = f2;
            f3_0 = f3;
            k++;


        } while (Math.abs(f1 * f2 / f3) > eps);
        return s;
    }


    private static void divide(int m, int n, Integer q, Integer r) {
        int mm;
        while (m > n) {

            mm = m - n;
            if (mm >= n) {
                q++;
            }
            m = mm;
        }
        r = m;
    }

    private static double calculate(int n, double x) {

        int f1;
        int f1_0 = 1;
        double f2;
        double f2_0 = 1;
        long f3;
        long f3_0 = 1;
        double s = 1;

        for (int k = 1; k <= n; k++) {

            f1 = -f1_0;
            f2 = f2_0 * x;
            f3 = f3_0 * k;

            double ss = f1 * f2 / f3;

            s += ss;

            System.out.println("ss = " + ss);

            f1_0 = f1;
            f2_0 = f2;
            f3_0 = f3;

        }
        return s;
    }
}
