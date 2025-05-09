package bt5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Course {
    private String courseId;
    private String title;
    private Instructor instructor;
    private ArrayList<Student> students = new ArrayList<>();
    private Map<Student, Double> grades = new HashMap<>();

    public Course(String courseId, String title, Instructor instructor) {
        this.courseId = courseId;
        this.title = title;
        this.instructor = instructor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void setGrade(Student student, double grade) {
        grades.put(student, grade);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Map<Student, Double> getGrades() {
        return grades;
    }

    public Instructor getInstructor() {
        return instructor;
    }
}
