import acm.program.ConsoleProgram;

import java.awt.*;

public class TowerOfHanoi extends ConsoleProgram {

    private static final int END_OF_INSERTING = 0;
    private int firstTower;
    private int extraTower;
    private int amountOfDisks;
    private int finalDestination;

    public void run() {

        Font f1 = new Font("Calibri", Font.PLAIN, 15);
        this.setFont(f1);
        int userInput;

        do {
            askUserInput();
            specifyTowerNumbers(finalDestination);
            solveHanoiTowers(amountOfDisks, firstTower, extraTower, finalDestination);
            println("If you would like to continue, press any number. If you want to stop the program, press 0");
            userInput = readInt();
        } while (userInput != 0);
    }

    private void askUserInput() {
        println("Please insert amount of disks and destination tower!");
        do {
            amountOfDisks = readInt("amount of disks: ");
            if (amountOfDisks <= 0) {
                println("Amount of disks should be a positive number.");
            }
        }
        while (amountOfDisks <= 0);

        do {
            finalDestination = readInt("destination - tower #");
            if (finalDestination != 1 && finalDestination != 2 && finalDestination != 3) {
                println("There are only three towers to choose from. Choose one of them.");
            }
        } while (finalDestination != 1 && finalDestination != 2 && finalDestination != 3);
    }

    private void specifyTowerNumbers(int finalDestination) {
        if (finalDestination == 1) {
            firstTower = 2;
            extraTower = 3;
            println("We start from the second tower and final destination is the first tower");
        } else if (finalDestination == 2) {
            firstTower = 1;
            extraTower = 3;
            println("We start from the first tower and final destination is the second tower");
        } else {
            firstTower = 1;
            extraTower = 2;
            println("We start from the first tower and final destination is the third tower");
        }
    }

    private void solveHanoiTowers(int disks, int from, int extra, int to) {
        if (disks == 1) {
            println("Disk 1 from tower " + from + " to tower " + to);
        } else {
            solveHanoiTowers(disks - 1, from, to, extra);
            println("Disk " + disks + " from tower " + from + " to tower " + to);
            solveHanoiTowers(disks - 1, extra, from, to);
        }
    }
}
