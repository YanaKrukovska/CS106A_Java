package ua.edu.ukma.ykrukovska.unit8;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class RollDice extends ConsoleProgram {
    private RandomGenerator randomNumbers = RandomGenerator.getInstance();

    private int amountOfSides;
    private int result1;
    private int result2;
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    private int amountOfDice;
    private int amountOfRounds;

    public void run() {

        Font font = new Font("Comic Sans", Font.PLAIN, 15);
        this.setFont(font);
        int userInput;

        do {
            askUserInput();
            int userAnswer;
            do {
                println("How many times would you like to roll the dice? If you want to select the number of rounds now, press 1." +
                        "If you want to decide whether to continue or not after each round, press 2");
                userAnswer = readInt("?:");
                if (userAnswer != 1 && userAnswer != 2){
                    println("Possible answers are 1 and 2. Choose any");
                }
            } while (userAnswer != 1 && userAnswer != 2);


            if (userAnswer == 2) {
                userAnswer = RollDiceOneTime();
            }

            if (userAnswer == 1) {
                RollDiceCertainAmountOfTimes();
            }
            calculateWinner();

            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();

        } while (userInput != 0);
    }

    private int RollDiceOneTime() {
        int userAnswer;
        do {
            playerOneRollDice();
            playerTwoRollDice();
            givePoints();
            println("Would you like to continue? Press 0 for no and any other number for yes.");
            userAnswer = readInt("?:");
            if (userAnswer == 0) {
                break;
            }

        } while (true);
        return userAnswer;
    }

    private void RollDiceCertainAmountOfTimes() {
        do {
            amountOfRounds = readInt("Amount of rounds: ");
        } while (amountOfRounds <= 0);
        for (int i = 1; i <= amountOfRounds; i++) {
            playerOneRollDice();
            playerTwoRollDice();
            givePoints();
        }
    }

    private void askUserInput() {
        do {
            amountOfDice = readInt("Amount of dice: ");
            if (amountOfDice <= 0) {
                println("Amount has to be a positive number");
            }
        } while (amountOfDice <= 0);
        do {
            amountOfSides = readInt("Amount of sides: ");
            if (amountOfSides <= 0) {
                println("Amount has to be a positive number");
            }
        } while (amountOfSides <= 0);
    }


    private void calculateWinner() {
        if (playerOnePoints > playerTwoPoints) {
            println("Player one won! He gained " + playerOnePoints + " points!");
        } else if (playerOnePoints < playerTwoPoints) {
            println("Player two won! He gained " + playerTwoPoints + " points!");
        } else {
            println("Players got the same amount of points!");
        }
    }

    private void givePoints() {
        if (result1 > result2) {
            playerOnePoints++;
            System.out.println("p1 points: " + playerOnePoints);
        } else if (result1 < result2) {
            playerTwoPoints++;
            System.out.println("p2 points: " + playerTwoPoints);

        }
    }

    private void playerTwoRollDice() {
        result2 = rollDice();
        println("Second player got " + result2);
    }

    private void playerOneRollDice() {
        result1 = rollDice();
        println("First player got " + result1);

    }

    private int rollDice() {
        int result = 0;
        for (int i = 1; i <= amountOfDice; i++) {
            result += randomNumbers.nextInt(1, amountOfSides);
        }
        return result;
    }


}
