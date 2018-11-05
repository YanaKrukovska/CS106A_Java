import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class GuessTheNumber extends ConsoleProgram {

    private RandomGenerator rgen = RandomGenerator.getInstance();

    public void run() {

        Font font = new Font("Comic Sans", Font.PLAIN, 15);
        this.setFont(font);

        int userInput;
        do {
            int randomNumber = rgen.nextInt(0, 100);
            userTriesToGuessNumber(randomNumber);
            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();
        } while (userInput != 0);

    }

    private void userTriesToGuessNumber(int randomNumber) {
        int userGuess;
        int amountOfAttempts = 0;
        do {
            userGuess = readInt("your guess:");
            if (userGuess < randomNumber) {
                println("It's bigger!");
            } else if (userGuess > randomNumber) {
                println("It's smaller!");
            } else {
                println("Correct!");
            }
            amountOfAttempts++;
        } while (userGuess != randomNumber);
        println("It took user " + amountOfAttempts + " attempts to guess the number");
    }


}
