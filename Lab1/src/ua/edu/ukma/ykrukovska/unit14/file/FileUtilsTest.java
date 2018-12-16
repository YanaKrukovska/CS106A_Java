package ua.edu.ukma.ykrukovska.unit14.file;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void replaceInFile() {
        String fileName = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\File.txt";
        FileUtils.replaceInFile(fileName, "I", "are not");

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

    @Test
    public void encryptFile() {
        String fileName = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\forEncryption.txt";
        String fileNameEncrypted = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\input_encrypted.txt";
        String fileNameDecrypted = "C:\\IdeaProjects\\CS106A_Java\\Lab1\\src\\ua\\edu\\ukma\\ykrukovska\\input_decrypted.txt";
        FileUtils.cipherFile(fileName, 13, fileNameEncrypted);
        FileUtils.cipherFile(fileNameEncrypted, 13, fileNameDecrypted);

    }

    @Test
    public void testString(){

        String s1 = "hello";
        String s2 = "hello";
        Assert.assertTrue(s1==s2);


        String s11 = new String( "hello");
        String s22 = new String("hello");
        Assert.assertTrue(s11==s22);
    }
}