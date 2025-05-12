package bt6;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private Instructor instructor;
    private List<Student> students = new ArrayList<>();

    public Course(String courseId, String courseName, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseName(String newName) {
        this.courseName = newName;
    }
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }
    public void printStudentList() {
        System.out.println("Students in course: " + courseName);
        for (Student s : students) {
            System.out.println("- " + s.getName() + " (ID: " + s.getId() + ")");
        }
    }
}

