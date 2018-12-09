package ua.edu.ukma.ykrukovska.unit13;

public enum Weekd {
    MONDAY(1,"Monday"),
    TUESDAY(2,"Tuesday"),
    WEDNESDAY(3,"Wednesday"),
    THURSDAY(4,"Thursday"),
    FRIDAY(5,"Friday"),
    SATURDAY(6,"Saturday"),
    SUNDAY(7,"Sunday");



    private int dayNumber;
    private String label;

    Weekd(int dayNumber, String label) {
        this.dayNumber = dayNumber;
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    @Override
    public String toString() {
        return  label + "("+dayNumber+")";
    }
}
