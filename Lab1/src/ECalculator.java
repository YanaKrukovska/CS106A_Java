public class ECalculator {

    private static final double X = 0.5;
    private static final double EP = 0.0000000000001;

    public static void main(String[] args) {
        double sn1;
        double sn0;
        int n = 3;
        do {
            sn1 = 1 + X + calculateSeries(n);

            sn0 = 1 + X + calculateSeries(n - 1);
            // System.out.println("sn1 = " + sn1);
            // System.out.println("sn0 = " + sn0);
            n++;
        } while (Math.abs(sn1 - sn0) > EP);
        System.out.println("final result is " + sn1 + "steps = " + (n - 2) + "check = " + Math.exp(X));


    }

    private static double calculateSeries(int n) {
        double result = 0;
        for (int i = 2; i <= n; i++) {
            result = result + Math.pow(X, i) / countFactorial(i);
        }
        return result;
    }


    private static long countFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * countFactorial(n - 1);
    }

    private static long countFactorialLoop(int n) {
        long factorial = 1;
        for (int i = n; i >= 1; i--) {
            factorial = i * factorial;

        }
        return factorial;

    }
}
