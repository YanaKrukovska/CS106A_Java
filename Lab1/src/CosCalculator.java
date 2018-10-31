public class CosCalculator {

    private static final double X = Math.PI/4;
    private static final double EP = 0.000000001;

    public static void main(String[] args) {
        testRecurrentCalculation();
        testRecursiveCalculation();

        System.out.println("Math.cos(X) = " + Math.cos(X));

    }

    private static void testRecurrentCalculation() {
        double sn1;
        double sn0;

        int n = 3;
        do {
            sn1 =  calculateSeriesRecurrent(n);
            sn0 =  calculateSeriesRecurrent(n - 1);

            n++;
        } while (Math.abs(sn1 - sn0) > EP);
        System.out.printf("Recurrent cos(x) calculation: precision = %20.19f, value = %20.19f, n = %d ", EP, sn1, (n - 2));
        System.out.println();
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
        System.out.printf("Recursive cos calculation: precision = %20.19f, value = %20.19f, n = %d  ", EP, sn1, (n - 2));
        System.out.println();

    }

    private static double calculateSeriesRecurrent(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result = result +calculateSeriesMember(i);
        }
        return  result;
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
        return Math.pow(-1, n)* Math.pow(X, 2*n) / factorial(2*n);

    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) { //recursion exit condition
            return 1;
        }
        return n * factorial(n - 1);
    }



}
