package ua.edu.ukma.ykrukovska.unit9;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String faculty;
    private String speciality;
    private int yearOfStudying;
    private static String universityName = "NauKMA";
    private int studentID;
    private static int studentCount = 0;

    public Student(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public Student() {
        this.studentID = ++studentCount;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setYearOfStudying(int yearOfStudying) {
        this.yearOfStudying = yearOfStudying;
    }

    public String getPersonalInformation() {
        String personalInformation = name + " " + surname;

        if (isAgeCorrect()) {
            personalInformation += " " + age + " years";

        } else {
            personalInformation += " Please check age: " + age + " It might be incorrect.";
        }
        return personalInformation;

    }

    public String getStudyingInformation() {
        String studyingInformation = universityName + " " + faculty + "-" + yearOfStudying + " " + speciality + " ID = " + studentID;
        return studyingInformation;
    }

    private boolean isAgeCorrect() {
        return age > 10 && age < 70;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " years " +
                " " + universityName + " " + faculty + "-" + yearOfStudying + " " + speciality +
                " ID = " + studentID;
    }
}
