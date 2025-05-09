package bt5;

import java.util.ArrayList;
import java.util.HashMap;

class Student extends User {
    private ArrayList<Course> enrolledCourses = new ArrayList<>();
    private HashMap<Course, Double> grades = new HashMap<>();

    public Student(String id, String name, String email) {
        super(id, name, email);
    }


    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " đã ghi danh vào khóa học " + course.getTitle());
        }
    }

    public void viewGrades() {
        for (HashMap.Entry<Course, Double> entry : grades.entrySet()) {
            System.out.printf("Khóa học: %s | Điểm: %.2f%n", entry.getKey().getTitle(), entry.getValue());
        }
    }

    public void setGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    @Override
    public void login() {
        System.out.println("Student " + name + " đã đăng nhập.");
    }

    @Override
    public void logout() {
        System.out.println("Student " + name + " đã đăng xuất.");
    }
}