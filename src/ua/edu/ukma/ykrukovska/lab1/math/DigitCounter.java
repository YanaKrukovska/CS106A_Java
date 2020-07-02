package ua.edu.ukma.ykrukovska.lab1.math;

public class DigitCounter {

    public static void main(String[] args) {
        System.out.println(countDigits(777));
    }

    private static int countDigits(int number) {
        if (number < 10) {
            return 1;
        }
        return 1 + countDigits(number / 10);
    }
}
