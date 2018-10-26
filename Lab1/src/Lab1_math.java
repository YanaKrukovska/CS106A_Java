import acm.program.ConsoleProgram;

public class Lab1_math extends ConsoleProgram {
    private static final int END_OF_INSERTING = 0;

    public void run() {

        int userAnswer;
        do {
            println("Choose task:");
            println("1.Pythagorean theorem");
            println("2.Max and min");
            println("3.Getting number one");
            println("Insert 0 to exit");
            userAnswer = readInt("?:");

            if (userAnswer == 1) {
                startPythagoreanTheorem();
            } else if (userAnswer == 2) {
                startFindingMaxAndMin();
            } else if (userAnswer == 3) {
                startGettingNumberOne();
            }

        } while (userAnswer != 0);
        println("Application has been stopped.");
    }


    private void startGettingNumberOne() {
        int userAnswer;
        do {
            int n = inputValidNumber();
            println("User input was " + n + " The process took " + transformToOne(n) + " steps");
            println("Press 3 to repeat. Insert any number to return to the list of tasks");

            userAnswer = readInt("");
        } while (userAnswer == 3);

    }

    private int inputValidNumber() {
        println("You chose task 3: insert any number bigger than 0 and the program will turn it into 1");
        int n;
        do {
            n = readInt("number:");
            if (n <= 0) {
                println("Incorrect input " + n + " Value must be positive");
            }

        } while (n <= 0);
        return n;
    }

    private int transformToOne(int n) {
        int amountOfSteps = 0;
        do {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            println("n = " + n);
            amountOfSteps++;

        } while (n != 1);
        return amountOfSteps;
    }

    private void startFindingMaxAndMin() {
        int userAnswer;
        do {
            println("You chose task 2. This program finds the largest and the smallest numbers. Enter 0 to stop find out the result");
            int largestNumber = 0;
            int smallestNumber = 0;
            int userInput;
            int inputAmount = 0;
            do {

                userInput = readInt("?:");

                if (userInput != END_OF_INSERTING) {
                    inputAmount++;
                    if (userInput > largestNumber || inputAmount == 1) {
                        largestNumber = userInput;
                    } else if (userInput < smallestNumber || inputAmount == 1) {
                        smallestNumber = userInput;
                    }
                }

            } while (userInput != END_OF_INSERTING);

            if (inputAmount == 0) {
                println("The user hasn't input any number");
            } else if (inputAmount == 1) {
                println("The largest number is " + largestNumber);
                println("The smallest number is " + largestNumber);

            } else {
                println("The largest number is " + largestNumber);
                println("The smallest number is " + smallestNumber);

            }
            println("Press 2 to repeat. Insert any number to return to the list of tasks");
            userAnswer = readInt("");
        } while (userAnswer == 2);

    }


    private void startPythagoreanTheorem() {
        int userAnswer;
        do {
            println("You chose task 1: calculate c by using pythagorean theorem");
            println("Enter values to compute Pythagorean theorem");

            double a = readDouble("a:");
            if (a < 0) {
                println("Wrong number. It has to be bigger than 0.");
                readDouble("a:");
            }
            double b = readDouble("b:");
            if (b < 0) {
                println("Wrong number. It has to be bigger than 0.");
                readDouble("b:");
            }

            println("c = " + Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5));
            println("Press 1 to repeat. Insert any number to return to the list of tasks");
            userAnswer = readInt("");
        } while (userAnswer == 1);

    }
}

