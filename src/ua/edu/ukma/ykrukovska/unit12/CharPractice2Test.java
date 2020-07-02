package ua.edu.ukma.ykrukovska.unit12;

import org.junit.Test;

public class CharPractice2Test {

    @Test
    public void splitString() {
        CharPractice2 testClass = new CharPractice2();
        testClass.calculateParts("cat      dog  bird   raccoon  2222 asd22      3aa 2.2 5,3");
    }
}