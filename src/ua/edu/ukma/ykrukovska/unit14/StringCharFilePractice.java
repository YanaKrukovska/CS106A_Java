package ua.edu.ukma.ykrukovska.unit14;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class StringCharFilePractice extends ConsoleProgram {

    public static final String FILE_PATH = "C:\\IdeaProjects\\CS106A_Java\\Song.txt";
    int userDecision;

    public void run() {
        this.setSize(600, 600);
        do {
            println("Choose a task: ");
            println("1. Add commas to big numbers");
            println("2. Edit specific symbol from line");
            println("3. Read file and search for a word/sentences in it");
            userDecision = readInt("Your answer: ");

            if (userDecision == 1) {
                int number;
                do {
                    number = readInt("Insert your number: ");
                    if (number < 0) {
                        do {
                            println("Insert only positive numbers");
                            number = readInt("Insert your number: ");
                        } while (number < 0);
                    }
                    if (number == 0) {
                        println("0");
                        break;
                    }
                    convertToString(number);
                    askToContinue();
                } while (userDecision != 0);
                run();
            }
            if (userDecision == 2) {
                editLine();
            }
            if (userDecision == 3) {

                try {
                    do {
                        readFile();
                        askToContinue();
                    } while (userDecision != 0);
                    run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } while (userDecision != 0);


    }

    private void readFile() throws IOException {

        String searchedWord = readLine("Insert phrase you are looking for: ");
        int occurrenceCounter = 0;
        BufferedReader txt = new BufferedReader(new FileReader(FILE_PATH));
        String line = txt.readLine();
        while (line != null) {

            occurrenceCounter += findOccurrenceAmount(line, searchedWord);
            println(line);
            line = txt.readLine();
        }
        println(" ");
        printResult(occurrenceCounter);

    }

    private void printResult(int occurrenceCounter) {
        if (occurrenceCounter > 0) {
            println("How many times this phrase has been found in the text: " + occurrenceCounter);
        } else {
            println("Your word hasn't been found!");
        }
    }

    public int findOccurrenceAmount(String line, String searchedPhrase) {

        StringTokenizer lineTokenizer = new StringTokenizer(line);
        StringTokenizer phraseTokenizer = new StringTokenizer(searchedPhrase);
        int occurrenceCounter = 0;
        int wordAmount = phraseTokenizer.countTokens();

        while (lineTokenizer.hasMoreTokens()) {
            String lWord = lineTokenizer.nextToken();
            phraseTokenizer = new StringTokenizer(searchedPhrase);
            int phraseAmount = 0;

            while (phraseTokenizer.hasMoreTokens()) {
                String fWord = phraseTokenizer.nextToken();
                if (lWord.equals(fWord)) {
                    phraseAmount++;
                    if (lineTokenizer.hasMoreTokens()) {
                        lWord = lineTokenizer.nextToken();
                    }
                } else {
                    phraseAmount = 0;
                    break;
                }
            }
            if (phraseAmount == wordAmount) {
                occurrenceCounter++;
            }
        }

        return occurrenceCounter;
    }

    private void editLine() {
        do {
            String str = readLine("Insert sentence: ");
            String toReplace = readLine("Insert what you want to delete: ");
            println("Your new line: " + removeAllOccurrences(str, toReplace.charAt(0)));
            askToContinue();
        } while (userDecision != 0);
        run();
    }

    private void askToContinue() {
        println(" ");
        println("Would you like to continue? 1- yes, 0 - no");
        userDecision = readInt("you answer: ");
        if (userDecision != 0 && userDecision != 1) {
            do {
                userDecision = readInt("you answer: ");
            } while (userDecision != 0 && userDecision != 1);
        }
    }

    public String removeAllOccurrences(String str, char ch) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public char convertToChar(int digit) {
        char result = ' ';
        if (digit == 0) result = '0';
        if (digit == 1) result = '1';
        if (digit == 2) result = '2';
        if (digit == 3) result = '3';
        if (digit == 4) result = '4';
        if (digit == 5) result = '5';
        if (digit == 6) result = '6';
        if (digit == 7) result = '7';
        if (digit == 8) result = '8';
        if (digit == 9) result = '9';
        return result;
    }

    public String convertToString(int number) {
        String result = "";
        int digitGroupCounter = 0;
        while (number > 0) {

            if (++digitGroupCounter == 3) {
                result = "," + convertToChar(number % 10) + result;
                digitGroupCounter = 0;
            } else {
                result = convertToChar(number % 10) + result;
            }
            number = number / 10;
        }
        if (result.charAt(0) == ',') {
            result = removeFirstSymbol(result);
        }
        println("Your new number is " + result);
        return result;

    }

    public String removeFirstSymbol(String str) {
        String result = "";
        for (int i = 1; i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }
}
