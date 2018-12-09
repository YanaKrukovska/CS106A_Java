package ua.edu.ukma.ykrukovska.unit13;

import acm.program.ConsoleProgram;

public class CharEnumPractice extends ConsoleProgram {

    int userDecision;

    public void run() {

        int userAnswer;

        this.setFont("Arial-18");
        println("Виберіть завдання: ");
        println("1. Перевірка символьної змінної");
        println("2. Розклад рейсів літаків");
        println("3. Дні тижня");
        println("4. Найпростійший калькулятор");
        println("5. Обчислення '5A-2B=N'");

        userAnswer = readInt(": ");

        if (userAnswer == 1) {
            checkType();
        }
        if (userAnswer == 2) {
            getAirplaneSchedule();
        }
        if (userAnswer == 3) {
            demoDays();
        }
        if (userAnswer == 4) {
            simpleCalculator();
        }
        if (userAnswer == 5) {
            countFunction();
        }

    }

    private void countFunction() {
        do {
            int n;
            n = readInt("Insert value of N: ");
            if (n < 3) {
                do {
                    println("Number must be > 3");
                    n = readInt("Insert value of N: ");
                } while (n < 3);
            }

            calculateAB(n);
            println("Would you like to continue? 1- yes, 0 - no");
            userDecision = readInt("you answer: ");
            if (userDecision != 0 && userDecision != 1) {
                do {
                    userDecision = readInt("you answer: ");
                } while (userDecision != 0 && userDecision != 1);
            }
            if (userDecision == 0) {
                run();
            }
        } while (userDecision != 0);
    }

    private void calculateAB(int n) {
        int minA = 0;
        int minB = 0;
        int minABSum = 0;
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                if (n == 5 * a - 2 * b) {
                    if (minABSum == 0) {
                        minA = a;
                        minB = b;
                        minABSum = a + b;
                    } else if (a + b < minABSum) {
                        minA = a;
                        minB = b;
                        minABSum = a + b;
                    }
                }
            }
        }
        println("A = " + minA + " B = " + minB + " A + B = " + minABSum);
    }

    private void demoDays() {
        do {
            int userNumber;

            userNumber = readInt("Insert number of the day: ");
            if (userNumber < 0 || userNumber > 7) {
                do {
                    println("Number can be from 1 to 7");
                    userNumber = readInt("Insert number of the day: ");
                } while (userNumber < 0 || userNumber > 7);
            }

            Weekd currentDay = Weekd.values()[userNumber - 1];

            println("Next day: " + getNextDay(currentDay));

            println("Would you like to continue? 1- yes, 0 - no");
            userDecision = readInt("you answer: ");
            if (userDecision != 0 && userDecision != 1) {
                do {
                    userDecision = readInt("you answer: ");
                } while (userDecision != 0 && userDecision != 1);
            }
            if (userDecision == 0) {
                run();
            }
        } while (userDecision != 0);

    }

    private void getAirplaneSchedule() {

        do {
            int userNumber;
            userNumber = readInt("Insert number of the day: ");
            if (userNumber < 0 || userNumber > 7) {
                do {
                    println("Number can be from 1 to 7");
                    userNumber = readInt("Insert number of the day: ");
                } while (userNumber < 0 || userNumber > 7);
            }

            getTextPresentation(userNumber);
            println("You chose " + getTextPresentation(userNumber));
            println("Would you like to continue? 1- yes, 0 - no");
            userDecision = readInt("you answer: ");
            if (userDecision != 0 && userDecision != 1) {
                do {
                    userDecision = readInt("you answer: ");
                } while (userDecision != 0 && userDecision != 1);
            }
            if (userDecision == 0) {
                run();
            }
        } while (userDecision != 0);
    }


    public static Weekd getNextDay(Weekd currentDay) {
        if (currentDay.getDayNumber() <= 6) {
            Weekd[] days = Weekd.values();
            return days[currentDay.getDayNumber()];
        } else {
            return Weekd.MONDAY;
        }
    }


    public static String getTextPresentation(int dayNumber) {
        return Weekd.values()[dayNumber - 1].getLabel();

    }


    private void checkType() {
        do {
            String insertedSymbols = readLine("Insert: ");
            char symbolToCheck = insertedSymbols.charAt(0);

            if (symbolToCheck >= 'A' && symbolToCheck <= 'Z') {
                println(symbolToCheck + " belongs to latin uppercase");
            } else if (symbolToCheck >= 'a' && symbolToCheck <= 'z') {
                println(symbolToCheck + " belongs to latin lowercase");
            } else if (symbolToCheck >= '0' && symbolToCheck <= '9') {
                println(symbolToCheck + " belongs to 0-9");
            } else {
                println("It doesn't belong to any type!");
            }
            println("Would you like to continue? 1- yes, 0 - no");
            userDecision = readInt("you answer: ");
            if (userDecision != 0 && userDecision != 1) {
                do {
                    userDecision = readInt("you answer: ");
                } while (userDecision != 0 && userDecision != 1);
            }
            if (userDecision == 0) {
                run();
            }
        } while (userDecision != 0);

    }


    private void simpleCalculator() {
        String divide = "/";
        String multiple = "*";
        String addition = "+";
        String subtraction = "-";

        do {
            println("Insert two numbers and action (+,-, *, /)");
            double a = readDouble("a = ");
            double b = readDouble("b = ");
            String action;
            action = readLine("action: ");
            if (actionDoesntExist(divide, multiple, addition, subtraction, action)) {
                do {
                    action = readLine("action: ");
                } while (actionDoesntExist(divide, multiple, addition, subtraction, action));
            }


            doCalculations(divide, multiple, addition, subtraction, a, b, action);
            println("Would you like to continue? 1- yes, 0 - no");
            userDecision = readInt("you answer: ");
            if (userDecision != 0 && userDecision != 1) {
                do {
                    userDecision = readInt("you answer: ");
                } while (userDecision != 0 && userDecision != 1);
            }
            if (userDecision == 0) {
                run();
            }
        } while (userDecision != 0);


    }

    private boolean actionDoesntExist(String divide, String multiple, String addition, String subtraction, String action) {
        return !action.equals(addition) && !action.equals(subtraction) && !action.equals(multiple)
                && !action.equals(divide);
    }

    private void doCalculations(String divide, String multiple, String addition, String subtraction, double a, double b, String action) {
        double result;
        if (action.equals(addition)) {
            result = a + b;
            println(a + " + " + b + " = " + result);
        } else if (action.equals(subtraction)) {
            result = a - b;
            println(a + " - " + b + " = " + result);
        } else if (action.equals(multiple)) {
            result = a * b;
            println(a + " * " + b + " = " + result);
        } else if (action.equals(divide)) {
            result = a / b;
            println(a + " / " + b + " = " + result);
        }
    }
}
