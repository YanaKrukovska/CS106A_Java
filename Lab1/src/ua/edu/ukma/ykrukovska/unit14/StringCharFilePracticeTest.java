package ua.edu.ukma.ykrukovska.unit14;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCharFilePracticeTest {

    private StringCharFilePractice testObject = new StringCharFilePractice();

    @Test
    public void findOneWord(){
        assertEquals(1, testObject.findOccurrenceAmount("I like cat","cat"));

    }

    @Test
    public void findTwoWord(){
        assertEquals(1, testObject.findOccurrenceAmount("I like cat and dog", "like cat"));

    }

    @Test
    public void findTwoWordTwice(){
        assertEquals(2, testObject.findOccurrenceAmount("I like cat  but I'm not sure that I really like cat", "like cat"));

    }

    @Test
           public void noOccurrence(){
            assertEquals(0, testObject.findOccurrenceAmount("I like cat", "I like panda"));

    }

    @Test
    public void emptyLine(){
        assertEquals(0, testObject.findOccurrenceAmount("", "I like panda"));

    }

    @Test
    public void findOneLetterWord(){
        assertEquals(1, testObject.findOccurrenceAmount("I like cat", "I"));

    }

    @Test
    public void convertDigitToChar(){
        assertEquals('1', testObject.convertToChar(1));

    }

    @Test
    public void convertIntToString(){
        assertEquals("123", testObject.convertToString(123));

    }

    @Test
    public void convertBigIntToString(){
        assertEquals("123,456,789", testObject.convertToString(123456789));

    }

    @Test
    public void convertBigIntToString2(){
        char e = '\'';
        String s = "\"";
        assertEquals("23,456,789", testObject.convertToString(23456789));

    }
}