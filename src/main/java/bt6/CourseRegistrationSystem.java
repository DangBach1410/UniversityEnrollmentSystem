package bt6;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationSystem {
    static List<Course> courses = new ArrayList<>();
    public static void main(String[] args) {
        // Tạo instructor
        Instructor ins1 = new Instructor("I01", "Dr. Smith");

        // Tạo courses
        addCourse(new Course("C001", "Java Programming", ins1));
        addCourse(new Course("C002", "Data Structures", ins1));

        // Tạo students
        Student s1 = new Student("S01", "Alice");
        Student s2 = new Student("S02", "Bob");

        // Đăng ký khoá học
        enrollCourse("C001", s1);
        enrollCourse("C001", s2);
        enrollCourse("C002", s1);

        // In danh sách học viên trước khi cập nhật và xóa
        printStudentsInCourse("C001");
        printStudentsInCourse("C002");

        // Cập nhật tên khóa học
        editCourseName("C001", "Java Core");

        // Xóa khóa học
        removeCourse("C002");

        // In danh sách học viên sau khi cập nhật và xóa
        printStudentsInCourse("C001");
        printStudentsInCourse("C002");

    }

    public static void enrollCourse(String courseId, Student student){
        Course c = getCourseById(courseId);
        c.addStudent(student);
    }

    public static void addCourse(Course course) {
        courses.add(course);
        System.out.println("Khóa học đã được thêm.");
    }

    public static void editCourseName(String courseId, String newName) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                c.setCourseName(newName);
                System.out.println("Tên khóa học đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy khóa học.");
    }

    public static void removeCourse(String courseId) {
        Course found = null;
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                found = c;
                break;
            }
        }
        if (found != null) {
            courses.remove(found);
            System.out.println("Đã xóa khóa học.");
        } else {
            System.out.println("Không tìm thấy khóa học.");
        }
    }
    public static void printStudentsInCourse(String courseId) {
        Course c = getCourseById(courseId);
        if (c != null) {
            c.printStudentList();
        } else {
            System.out.println("Không tìm thấy khóa học.");
        }
    }

    public static Course getCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }
}
