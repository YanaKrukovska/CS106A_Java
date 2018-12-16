package ua.edu.ukma.ykrukovska.unit14.file;

import acm.program.ConsoleProgram;
import ua.edu.ukma.ykrukovska.unit14.utils.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDemoTask extends ConsoleProgram {
    public static final String FILE_PATH = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\unit14\\files\\File.txt";
    public static final String WORKING_FOLDER = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\unit14\\files\\";
    public static final String FILE_FOR_ENCRYPTION = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\unit14\\files\\forEncryption.txt";

    @Override
    public void run() {

        this.setSize(600, 600);
        int userAnswer;

        println("Choose a task: ");
        println("1. Заміна підстрічки заданою стрічкою");
        println("2. Копія змісту тектового файлу в інший з розширення ");
        println("3. Формування двох файлів з рядків іншого ");
        println("4. Шифрування файлу за використання зсуву символів та його розшифрування");

        userAnswer = readInt("Your answer: ");
        if (userAnswer < 1 || userAnswer > 4) {
            do {
                println("You answer can be 1,2,3,4 only. Try again ");
                userAnswer = readInt("Your answer: ");
            } while (userAnswer < 0 || userAnswer > 0);

        }

        if (userAnswer == 1) {
            println("");
            printFileIntoConsole(FILE_PATH);
            println("");
            String find = readLine("Insert what you want to find: ");
            String replace = readLine("Insert what you with what you want to replace: ");
            println("");
            FileUtils.replaceInFile(FILE_PATH, find, replace);
            printFileIntoConsole(FILE_PATH);
            run();
        } else if (userAnswer == 2) {
            String fileName = readLine("Insert file name to backup: ");
            FileUtils.createFileBackup(WORKING_FOLDER + fileName);
            run();
        } else if (userAnswer == 3) {
            println("");
            printFileIntoConsole(FILE_PATH);
            println("");
            FileUtils.splitFile(FILE_PATH);
            println("");
            println("Odd lines: ");
            println("");
            printFileIntoConsole(FILE_PATH.replaceAll(".txt", "_odd.txt"));
            println("");
            println("");
            println("Even lines:");
            println("");
            printFileIntoConsole(FILE_PATH.replaceAll(".txt", "_even.txt"));
            println("");
            run();
        } else if (userAnswer == 4) {
            println("");
            int shift = readInt("Insert shift: ");
            String processedFileName = readLine("Insert processed file name: ");
            FileUtils.cipherFile(FILE_FOR_ENCRYPTION, shift, WORKING_FOLDER + processedFileName);
            printFileIntoConsole(WORKING_FOLDER + processedFileName);
            String encryptedFile = WORKING_FOLDER + processedFileName;
            println("");

            doEncryption(shift, encryptedFile);

            run();
        }


    }

    private void doEncryption(int shift, String encryptedFile) {
        int userReply;
        println("Would you like to decrypt it? 1 - yes, 0 - no");
        userReply = readInt("You answer: ");
        if (userReply == 1) {
            String reprocessedFileName = readLine("Insert processed file name: ");
            FileUtils.cipherFile(encryptedFile, 26 - shift, WORKING_FOLDER + reprocessedFileName);
            String decryptedFile = WORKING_FOLDER + reprocessedFileName;
            println("Decrypted file: ");
            printFileIntoConsole(decryptedFile);
        }
    }

    private void printFileIntoConsole(String fileName) {
        try (BufferedReader inputData = new BufferedReader(new FileReader(fileName))) {
            String line = inputData.readLine();
            while (line != null) {
                println(line);
                line = inputData.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

