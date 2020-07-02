package ua.edu.ukma.ykrukovska.unit9;

import acm.program.ConsoleProgram;

public class StudentDescriptionProvider extends ConsoleProgram {

    public void run() {

        Student student = new Student();
        student.setAge(23);
        student.setName("Justin");
        student.setSurname("Bieber");
        student.setFaculty("FI");
        student.setSpeciality("CS");
        student.setYearOfStudying(1);
        println(student.getPersonalInformation());
        println(student.getStudyingInformation());

        Student student1 = new Student("Oleg", "Vynnyk");
        student1.setAge(42);
        student1.setFaculty("Philology");
        student1.setSpeciality("Ukrainian philology");
        student1.setYearOfStudying(4);
        println(student1.getPersonalInformation());
        println(student1.getStudyingInformation());

        Student student2 = new Student("Mykhailo", "Poplavskyi");
        student2.setAge(69);
        student2.setFaculty("Economics");
        student2.setSpeciality("International relations");
        student2.setYearOfStudying(6);
        println(student2.toString());

    }
}