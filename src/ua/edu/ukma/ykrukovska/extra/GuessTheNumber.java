package ua.edu.ukma.ykrukovska.extra;

import acm.program.ConsoleProgram;

import java.util.Random;

public class GuessTheNumber extends ConsoleProgram {

    public void run() {

        int userInput;
        int randomNumber = randInt(0, 100);
        int stepsAmount = 0;
        System.out.println(randomNumber);
        do {
            userInput = readInt("?:");
            if (userInput > randomNumber) {
                println("The number should be smaller");
            } else if (userInput < randomNumber) {
                println("The number should be bigger");
            }
            stepsAmount++;
        } while (userInput != randomNumber);
        if (userInput == randomNumber) {
            println("Correct!");
            println("You used" + stepsAmount + " turns");
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}