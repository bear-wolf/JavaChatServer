package service;

import domain.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentService {
    private List<Student> students;
    {
        students = new LinkedList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Goodall"));
        students.add(new Student(3, "Max", "Born"));
    }

    public Student getStudent(int id) {
        switch (id) {
            case 1:
                return students.get(0);
            case 2:
                return students.get(1);
            case 3:
                return students.get(2);
            default:
                return null;
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
