import acm.program.ConsoleProgram;

public class ECalculator extends ConsoleProgram {

    private static double X;
    private static double EP;

    public void run() {

        EP = readDouble("EP = ");

        do {
            X = readDouble("X = ");
            if (X < 0 || X > 1) {
                println("Wrong number! It should be 0 =< X < 1");
            }
        } while (!(X >= 0 && X < 1));

        testRecurrentCalculation();
        testRecursiveCalculation();

        println("Math.exp(X) = " + Math.exp(X));

    }

    private static void testRecurrentCalculation() {
        double sn1;
        double sn0;

        int n = 3;
        do {
            sn1 = calculateSeriesRecurrent(n);
            sn0 = calculateSeriesRecurrent(n - 1);

            n++;
        } while (Math.abs(sn1 - sn0) > EP);

    }

    //test recursive calculation
    private static void testRecursiveCalculation() {
        double sn1;
        double sn0;
        int n = 3;
        do {
            sn1 = calculateRecursive(n);
            sn0 = calculateRecursive(n - 1);
            n++;
        } while (Math.abs(sn1 - sn0) > EP);


    }

    private static double calculateSeriesRecurrent(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result = result + calculateSeriesMember(i);
        }
        return result;
    }

    //Calculate series recursive
    public static double calculateRecursive(int n) {
        double result = 0;
        if (n == 0) {//recursion exit condition
            return 1;
        }
        result += calculateSeriesMember(n) + calculateRecursive(n - 1);

        return result;
    }

    //calculates n-member of series
    private static double calculateSeriesMember(int n) {
        return Math.pow(X, n) / factorial(n);

    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) { //recursion exit condition
            return 1;
        }
        return n * factorial(n - 1);
    }


}
