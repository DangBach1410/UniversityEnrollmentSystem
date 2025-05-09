package bt5;

import java.util.ArrayList;

class Instructor extends User {
    private ArrayList<Course> courseList = new ArrayList<>();

    public Instructor(String id, String name, String email) {
        super(id, name, email);
    }

    public Course createCourse(String courseId, String title) {
        Course c = new Course(courseId, title, this);
        courseList.add(c);
        return c;
    }

    public void gradeStudent(Course course, Student student, double grade) {
        if (course.getStudents().contains(student)) {
            student.setGrade(course, grade);
            course.setGrade(student, grade);
        }
    }

    @Override
    public void login() {
        System.out.println("Instructor " + name + " đã đăng nhập.");
    }

    @Override
    public void logout() {
        System.out.println("Instructor " + name + " đã đăng xuất.");
    }
}