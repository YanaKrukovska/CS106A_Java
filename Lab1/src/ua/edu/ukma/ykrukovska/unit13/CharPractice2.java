package ua.edu.ukma.ykrukovska.unit13;

import acm.program.ConsoleProgram;

public class CharPractice2 extends ConsoleProgram {

    private String userInput;

    public void run() {

        userInput = readLine("Insert: ");

        calculateParts(userInput);

        keepLettersOnly();
        removeExtraWhitespaces();

    }

    public static boolean isStringNumber(String source) {
        boolean result = true;
        for (int i = 0; i < source.length(); i++) {
            char currentSymbol = source.charAt(i);
            if (!(Character.isDigit(currentSymbol) || currentSymbol == '.' || currentSymbol == ',')) {
                return false;
            }
        }
        return result;
    }

    public void calculateParts(String source) {
        source = removeSpaces(source);
        int wordCounter = 0;
        int numberCounter = 0;
        int notCapitalLetterCounter = 0;
        String capitalLetterWords = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < source.length(); i++) {
            char symbol = source.charAt(i);
            if (Character.isWhitespace(symbol) || i == source.length() - 1) {

                end = (i == source.length() - 1) ? i + 1 : i;
                String substring = source.substring(start, end);
                if (isStringWord(substring)) {
                    wordCounter++;
                }
                if (isStringNumber(substring)) {
                    numberCounter++;
                }
                if (isStartedFromCapital(substring)){
                    capitalLetterWords += substring + " ";
                }
                System.out.println(substring);
                start = end + 1;

            }
        }
        println("1. Amount of words: " + wordCounter);
        println("2. Amount of numbers: " + numberCounter);
        println("3. Capital letter words: " + capitalLetterWords);
    }

    public static boolean isStringWord(String source) {
        return !isStringNumber(source);
    }

    public static boolean isStartedFromCapital(String source) {
        return Character.isUpperCase(source.charAt(0));
    }


    private void removeExtraWhitespaces() {
        println(" ");
        println("5. Line with single whitespaces: ");
        for (int i = 0; i < userInput.length(); i++) {
            if (!(Character.isWhitespace(userInput.charAt(i)))) {
                print(userInput.charAt(i));
            } else if (Character.isWhitespace(userInput.charAt(i)) && !Character.isWhitespace(userInput.charAt(i + 1))) {
                print(userInput.charAt(i));
            }
        }
    }


    public static String removeSpaces(String source) {
        String result = "";
        for (int i = 0; i < source.length(); i++) {
            if (!(Character.isWhitespace(source.charAt(i)))) {
                result += source.charAt(i);
            } else if (Character.isWhitespace(source.charAt(i)) && !Character.isWhitespace(source.charAt(i + 1))) {
                result += source.charAt(i);
            }
        }
        return result;
    }

    private void keepLettersOnly() {
        println("4. Line with just letters: ");
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isLetter(userInput.charAt(i))) {
                print(userInput.charAt(i));
            }
        }


    }


    private int countChar(String userInput) {
        int count = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) >= '0' && userInput.charAt(i) <= '9') {
                count++;
            }
        }

        return count;
    }


}
