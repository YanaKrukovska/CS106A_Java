package ua.edu.ukma.ykrukovska.unit11;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class MethodsPractice extends ConsoleProgram {

    int userAnswer;

    public void run() {

        setFont("Arial-24");
        writeName();
        tenPositivePowerToTwo();
        tenOddPowerToTwo();
        countSumOfNumbers();
        countSumOfOddNumbers();
        countSumOfFractions();
        powersOfTwo();
        showFactorial();
        function();
        calculateTenRandomNumbers();
        priceList();
        playCalculatingGame();
        sumAndMean();
        findBiggestNumber();
        checksPrimeNumbers();
        guessNumberGame();

    }

    private void playCalculatingGame() {
        println("12. Checks your skills at '+' and '-' operations.");
        do {
            RandomGenerator randomNumbers = RandomGenerator.getInstance();
            int x;
            int y;
            int userScore = 0;

            for (int i = 1; i <= 5; i++) {
                do {
                    x = randomNumbers.nextInt(1, 100);
                    y = randomNumbers.nextInt(1, 100);
                } while (x + y > 100);


                println(x + "+" + y + " = ");
                int answer = readInt();

                if (answer == x + y) {
                    userScore++;
                }
            }

            for (int i = 1; i <= 5; i++) {
                do {
                    x = randomNumbers.nextInt(1, 100);
                    y = randomNumbers.nextInt(1, 100);
                } while (x - y < 0);

                println(x + "-" + y + " = ");
                int answer = readInt();

                if (answer == x - y) {
                    userScore++;
                }
            }

            println("User score = " + userScore);
            if (userScore == 10) {
                println("Відмінно");
            } else if (userScore == 9 || userScore == 8) {
                println("Добре");
            } else if (userScore == 7 || userScore == 6) {
                println("Задовільно");
            } else {
                println("Погано");
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void checkIfAnswerIsPossible() {
        if (userAnswer != 1 && userAnswer != 0) {
            println("You can only answer 0 and 1. Try again");
            userAnswer = readInt();
        }
    }

    private void priceList() {
        println("11. Shows prices of apples depending on their amount");
        int price;
        do {
            price = readInt("Price = ");
            for (int amountOfApples = 100; amountOfApples <= 1000; amountOfApples += 100) {
                println(amountOfApples + " grams of apples cost " + calculatePrice(amountOfApples, price) + " hrn");
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
        } while (userAnswer != 0);
    }

    private double calculatePrice(double amountOfApples, int price) {
        return amountOfApples / 1000 * price;
    }

    private void guessNumberGame() {
        println("16. Makes player guess the number");

        do {
            RandomGenerator rgen = RandomGenerator.getInstance();

            int randomNumber = rgen.nextInt(1, 100);
            userTriesToGuessNumber(randomNumber);
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void userTriesToGuessNumber(int randomNumber) {
        int userGuess;
        int amountOfAttempts = 0;
        do {
            userGuess = readInt("your guess: ");

            if (userGuess < randomNumber) {
                println("It's bigger!");
            } else if (userGuess > randomNumber) {
                println("It's smaller!");
            }
            amountOfAttempts++;
            if (amountOfAttempts > 7) {
                println("Game over!");
                break;
            }
        } while (userGuess != randomNumber);
        if (userGuess == randomNumber) {
            println("Correct! It is " + randomNumber + "! It took user " + amountOfAttempts + " attempts to guess the number");
        }


    }

    private double calculateFunction(double x) {
        return -2.4 * Math.pow(x, 2) + 5 * x - 3;
    }

    private void function() {
        println("9. Calculates function y = -2,4*х^2+5*х-3 .");
        do {
            for (double x = -2.0; x <= 2; x += 0.5) {
                println("x = " + x + "; y = " + calculateFunction(x));
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void showFactorial() {
        do {
            println("8. Calculates factorial of inserted number.");
            println("Insert number: ");
            int n = readInt("n = ");
            if (n < 0) {
                println("Number must be positive");
                n = readInt();
            }
            calculateFactorial(n);
            println("n! = " + calculateFactorial(n));
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void checksPrimeNumbers() {
        println("15. Checks if inserted number is a prime number");
        do {
            int userInput = readInt();
            if (userInput < 0) {
                println("Number must be positive");
                userInput = readInt();
            }
            if (userInput == 2 || userInput == 3 || userInput == 7 || userInput == 5) {
                println(userInput + " is a prime number");
            } else if (userInput % 2 == 0 || userInput % 3 == 0 || userInput % 7 == 0 || userInput % 5 == 0) {
                println(userInput + " is not a prime number");
            } else {
                println(userInput + " is a prime number");
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void findBiggestNumber() {
        println("14. Finds the biggest inserted number");
        do {
            int userNumber;
            int biggestNumber = 0;
            println("Insert 0 to stop");
            do {
                userNumber = readInt();
                if (userNumber < 0) {
                    println("Number must be positive");
                    userNumber = readInt();
                }
                if (userNumber > biggestNumber) {
                    biggestNumber = userNumber;
                }
            } while (userNumber != 0);
            println("Biggest number is " + biggestNumber);

            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void sumAndMean() {
        println("13. Calculates sum and mean of inserted numbrs");
        do {
            int userNumber;
            int sum = 0;
            int amountOfNumbers = 0;
            println("Insert 0 to stop");
            do {
                userNumber = readInt();
                if (userNumber < 0) {
                    println("Number must be positive");
                    userNumber = readInt();

                }
                sum = sum + userNumber;
                amountOfNumbers++;
            } while (userNumber != 0);
            println("Sum = " + sum);
            println("Mean = " + (double) sum / (amountOfNumbers - 1));

            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void calculateTenRandomNumbers() {
        println("10. Generates 10 random numbers and calculates their mean.");
        do {
            int randomNumbersSum = 0;
            RandomGenerator rgen = RandomGenerator.getInstance();

            for (int i = 1; i <= 10; i++) {
                int randomNumber = rgen.nextInt(0, 10);
                randomNumbersSum = randomNumbersSum + randomNumber;
                println(randomNumber);
                System.out.println(randomNumbersSum);
            }
            println("Mean = " + (randomNumbersSum / 10.));

            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);


    }

    private int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);

    }

    private void powersOfTwo() {
        println("7. Calculates powers of 2.");
        do {
            for (int i = 0; i <= 10; i++) {
                println(2 + "^" + i + " = " + (int) Math.pow(2, i));
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void countSumOfFractions() {
        println("6. Counting sum of certain amount of fractions.");
        do {
            int amountOfNumbers;
            double sum = 0;
            amountOfNumbers = readInt("Amount of numbers: ");

            if (amountOfNumbers < 0) {
                println("Amount of numbers must be positive!");
                amountOfNumbers = readInt("Amount of numbers: ");
            }

            for (int i = 1; i <= amountOfNumbers; i++) {
                sum = sum + (1. / i);
            }
            println("Sum = " + sum);
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void countSumOfOddNumbers() {

        println("5. Counting sum of certain amount of odd numbers.");
        do {
            int amountOfNumbers;
            int sum = 0;
            amountOfNumbers = readInt("Amount of numbers: ");

            if (amountOfNumbers < 0) {
                println("Amount of numbers must be positive!");
                amountOfNumbers = readInt("Amount of numbers: ");
            }

            for (int i = 1; i <= amountOfNumbers; i++) {
                if (i % 2 != 0) {
                    sum = sum + i;

                }
            }
            println("Sum = " + sum);
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void countSumOfNumbers() {
        println("4. Counting sum of certain amount of numbers.");

        do {
            int sum = 0;
            int amountOfNumbers;
            amountOfNumbers = readInt("Amount of numbers: ");
            if (amountOfNumbers < 0) {
                println("Amount of numbers must be positive!");
                amountOfNumbers = readInt("Amount of numbers: ");
            }
            for (int i = 1; i <= amountOfNumbers; i++) {
                sum = sum + i;
            }
            println("Sum = " + sum);
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void tenOddPowerToTwo() {
        println("3. Powering first 5 positive odd numbers to two.");
        do {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    println(i + "^2 - " + (int) Math.pow(i, 2));
                }
            }

            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void tenPositivePowerToTwo() {
        println("2. Powering first 10 positive numbers to two.");
        do {
            double result = 1.0;
            for (int i = 1; i <= 10; i++) {
                result = Math.pow(i, 2);
                println(i + "^2 - " + result);
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }

    private void writeName() {
        println("1. Writing name 10 times.");
        do {
            println("Insert name: ");
            String name = readLine();
            for (int i = 1; i <= 10; i++) {
                println(name);
            }
            println("Do you want to continue this task? no-0; yes-1 ");
            userAnswer = readInt();
            checkIfAnswerIsPossible();
        } while (userAnswer != 0);
    }
}
