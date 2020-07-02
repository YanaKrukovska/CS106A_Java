package ua.edu.ukma.ykrukovska.unit13;

import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class CharEnumPracticeTest {

    @org.junit.Test
    public void getTextPresentation() {
        assertEquals("Monday", CharEnumPractice.getTextPresentation(1));
    }

    @org.junit.Test
    @Ignore
    public void getTextPresentationWrongIndex() {
        assertEquals("Monday", CharEnumPractice.getTextPresentation(8));
    }

    @org.junit.Test
    public void getNextDayForMonday() {
        assertEquals(Weekd.TUESDAY, CharEnumPractice.getNextDay(Weekd.MONDAY));
    }

    @org.junit.Test
    public void getNextDayForSunday() {
        assertEquals(Weekd.MONDAY, CharEnumPractice.getNextDay(Weekd.SUNDAY));
    }

    @org.junit.Test
    public void getNextDayForSaturday() {
        assertEquals(Weekd.SUNDAY, CharEnumPractice.getNextDay(Weekd.SATURDAY));
    }


}