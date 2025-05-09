package bt5;

import java.util.ArrayList;
import java.util.HashMap;

class LearningManagementSystem {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Instructor i1 = new Instructor("I01", "Thầy Nam", "nam@edu.vn");
        Student s1 = new Student("S01", "Lan", "lan@student.vn");
        Student s2 = new Student("S02", "Minh", "minh@student.vn");

        addUser(i1);
        addUser(s1);
        addUser(s2);

        Course java = i1.createCourse("C01", "Lập trình Java");
        Course web = i1.createCourse("C02", "Thiết kế Web");

        addCourse(java);
        addCourse(web);

        s1.enrollCourse(java);
        s2.enrollCourse(java);
        s1.enrollCourse(web);

        i1.gradeStudent(java, s1, 8.5);
        i1.gradeStudent(java, s2, 7.0);
        i1.gradeStudent(web, s1, 9.0);

        System.out.println("Diem cua hoc sinh " + s1.getName() + ":");
        s1.viewGrades();

        System.out.println("\nBảng điểm: ");
        showAllGrades();
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void addCourse(Course course) {
        courses.add(course);
    }

    public static void showAllGrades() {
        for (Course c : courses) {
            System.out.println("Khóa học: " + c.getTitle());
            for (HashMap.Entry<Student, Double> entry : c.getGrades().entrySet()) {
                System.out.println("Sinh viên: " + entry.getKey().name + " | Điểm: " + entry.getValue());
            }
            System.out.println();
        }
    }
}

