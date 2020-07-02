package ua.edu.ukma.ykrukovska.unit8;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

import java.awt.*;


public class GuessTheNumber extends ConsoleProgram {

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private static final int THE_SMALLEST_NUMBER = 0;
    private static final int THE_BIGGEST_NUMBER = 100;

    public void run() {

        Font font = new Font("Comic Sans", Font.PLAIN, 15);
        this.setFont(font);

        int userInput;
        do {
            int randomNumber = rgen.nextInt(THE_SMALLEST_NUMBER, THE_BIGGEST_NUMBER);
            userTriesToGuessNumber(randomNumber);
            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();
        } while (userInput != 0);

    }

    private void userTriesToGuessNumber(int randomNumber) {
        int userGuess;
        int amountOfAttempts = 0;
        do {
            userGuess = readInt("your guess: ");
            userGuess = checkDomain(userGuess);

            if (userGuess < randomNumber) {
                println("It's bigger!");
            } else if (userGuess > randomNumber) {
                println("It's smaller!");
            }
            amountOfAttempts++;
        } while (userGuess != randomNumber);
        println("Correct! It is " + randomNumber + "! It took user " + amountOfAttempts + " attempts to guess the number");
    }

    private int checkDomain(int userGuess) {
        do {
            if (userGuess < THE_SMALLEST_NUMBER || userGuess > THE_BIGGEST_NUMBER) {
                println("You number is not included in the domain. Try again");
                userGuess = readInt("your guess: ");
            }
        } while (userGuess < THE_SMALLEST_NUMBER || userGuess > THE_BIGGEST_NUMBER);
        return userGuess;
    }


}
