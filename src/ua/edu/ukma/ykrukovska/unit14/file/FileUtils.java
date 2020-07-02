package ua.edu.ukma.ykrukovska.unit14.file;

import ua.edu.ukma.ykrukovska.unit14.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class FileUtils {
    public static final String WORKING_FOLDER = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\ua\\edu\\ukma\\ykrukovska\\uni14\\files\\";

    public static void replaceInFile(String fileName, String find, String replace) {
        if (fileName == null || fileName.isEmpty() || find == null || find.isEmpty() || replace == null || replace.isEmpty()) {
            return;
        }

        try (
                BufferedReader inputData = new BufferedReader(new FileReader(fileName));
                PrintWriter outputData = new PrintWriter(fileName + ".tmp")
        ) {

            String line = inputData.readLine();
            while (line != null) {
                outputData.println(StringUtils.replaceSubstring(line, find, replace));
                line = inputData.readLine();
            }

        } catch (Exception e) {
            //something wrong happened
        }
        File outputData = new File(fileName + ".tmp");
        File oldFile = new File(fileName);
        oldFile.delete();
        outputData.renameTo(oldFile);

    }

    public static void createFileBackup(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return;
        }
        try (
                BufferedReader inputData = new BufferedReader(new FileReader(fileName)); // input data
                PrintWriter outputData = new PrintWriter(fileName.replaceAll(".txt", ".bak"))//output data
        ) {
            String line = inputData.readLine();
            while (line != null) {
                outputData.println(line);
                line = inputData.readLine();
            }
        } catch (Exception e) {
            //something wrong happened
        }
    }

    public static void splitFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            //do nothing if file name is  not valid
            return;
        }

        try (
                BufferedReader inputData = new BufferedReader(new FileReader(fileName));
                PrintWriter outputOddData = new PrintWriter(fileName.replaceAll(".txt", "_odd.txt"));
                PrintWriter outputEvenData = new PrintWriter(fileName.replaceAll(".txt", "_even.txt"));
        ) {
            String line = inputData.readLine();
            int lineCounter = 1;
            while (line != null) {
                if (lineCounter % 2 == 0) {
                    outputEvenData.println(line);
                } else {
                    outputOddData.println(line);
                }
                line = inputData.readLine();
                lineCounter++;
            }

        } catch (Exception e) {
            //something wrong happened
        }
    }

    public static void cipherFile(String fileName, int shift, String processedFileName) {
        if (fileName == null || fileName.isEmpty() || processedFileName == null || processedFileName.isEmpty()) {
            return;
        }
        if (shift <= 0) {
            return;
        }

        try (
                BufferedReader inputData = new BufferedReader(new FileReader(fileName));
                PrintWriter encryptedData = new PrintWriter(processedFileName);
        ) {

            String line = inputData.readLine();
            while (line != null) {
                encryptedData.println(StringUtils.cipher(line, shift));
                line = inputData.readLine();
            }

        } catch (Exception e) {
            //something wrong happened
        }
    }

}
