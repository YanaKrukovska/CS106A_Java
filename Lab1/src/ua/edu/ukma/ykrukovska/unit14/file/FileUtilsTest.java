package ua.edu.ukma.ykrukovska.unit14.file;

import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void replaceInFile() {
        String fileName = "e://IDAE Projects//CS106A_Java//Lab1//resources//input.txt";
        FileUtils.replaceInFile(fileName, "are", "are not");

    }

    @Test
    public void createFileBackup() {
        String fileName = "e://IDAE Projects//CS106A_Java//Lab1//resources//input.txt";
        FileUtils.createFileBackup(fileName);
    }

    @Test
    public void splitFile() {
        String fileName = "e://IDAE Projects//CS106A_Java//Lab1//resources//input.txt";
        FileUtils.splitFile(fileName);
    }
}