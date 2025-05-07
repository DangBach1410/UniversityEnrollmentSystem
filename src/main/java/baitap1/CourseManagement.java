package baitap1;

import java.time.LocalDate;
import java.util.*;

public class CourseManagement {
    private static HashMap<String, Student> students = new HashMap<>();
    private static HashMap<String, Course> courses = new HashMap<>();
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement courseManagement = new CourseManagement();

        // Thêm sinh viên và khóa học
        addStudent("S01", "Nguyen Anh Tuan", "tuan@domain.com");
        addStudent("S02", "Tran Thi Lan", "lan@domain.com");
        addStudent("S03", "Le Van Binh", "binh@domain.com");
        addStudent("S04", "Pham Thi Hoa", "hoa@domain.com");
        addStudent("S05", "Doan Quoc Hung", "hung@domain.com");
        addStudent("S06", "Vu Thi Minh", "minh@domain.com");
        addCourse("C01", "Java Basics", 2);
        addCourse("C02", "Advanced Java", 1);
        addCourse("C03", "Web Development", 2);
        addCourse("C04", "Data Structures", 3);
        addCourse("C05", "Database Systems", 4);

        // Sinh viên đăng ký khóa học
        enrollStudent("S01", "C01");
        enrollStudent("S02", "C02");
        enrollStudent("S03", "C03");
        enrollStudent("S04", "C03");
        enrollStudent("S05", "C04");
        enrollStudent("S06", "C04");
        enrollStudent("S01", "C05");
        enrollStudent("S02", "C05");
        enrollStudent("S03", "C05");
        enrollStudent("S04", "C05");

        // In danh sách sinh viên của một khóa học
        printStudentsInCourse("C03");

        // In danh sách khóa học của một sinh viên
        printCoursesOfStudent("S01");

        // Thống kê khóa học có nhiều sinh viên nhất
        courseWithMostStudents();

        // Thống kê sinh viên đăng ký nhiều khóa học nhất
        studentWithMostCourses();
    }

    // Thêm sinh viên
    public static void addStudent(String id, String name, String email) {
        Student student = new Student(id, name, email);
        students.put(id, student);
    }

    // Thêm khóa học
    public static void addCourse(String id, String title, int maxStudents) {
        Course course = new Course(id, title, maxStudents);
        courses.put(id, course);
    }

    // Đăng ký sinh viên vào khóa học
    public static boolean enrollStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("Sinh viên hoặc khóa học không tồn tại!");
            return false;
        }

        long enrolledCount = enrollments.stream()
                .filter(e -> e.getCourse().equals(course))
                .count();

        if (enrolledCount >= course.getMaxStudents()) {
            System.out.println("Khóa học đã đủ số lượng sinh viên!");
            return false;
        }

        boolean alreadyEnrolled = enrollments.stream()
                .anyMatch(e -> e.getStudent().equals(student) && e.getCourse().equals(course));

        if (alreadyEnrolled) {
            System.out.println("Sinh viên đã đăng ký khóa học này rồi!");
            return false;
        }

        enrollments.add(new Enrollment(student, course, LocalDate.now()));
        System.out.println("Đăng ký thành công!");
        return true;
    }

    // In danh sách sinh viên của một khóa học, sắp xếp theo ngày đăng ký
    public static void printStudentsInCourse(String courseId) {
        Course course = courses.get(courseId);
        if (course == null) {
            System.out.println("Khóa học không tồn tại!");
            return;
        }

        ArrayList<Enrollment> courseEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().equals(course)) {
                courseEnrollments.add(enrollment);
            }
        }

        courseEnrollments.sort(Comparator.comparing(Enrollment::getEnrollmentDate));

        System.out.println("Danh sách sinh viên trong khóa học " + courseId + ":");
        for (Enrollment enrollment : courseEnrollments) {
            Student student = enrollment.getStudent();
            System.out.println(student.getName() + " - " + enrollment.getEnrollmentDate());
        }
    }

    // In danh sách khóa học của một sinh viên
    public static void printCoursesOfStudent(String studentId) {
        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Sinh viên không tồn tại!");
            return;
        }

        System.out.println("Danh sách khóa học của sinh viên " + studentId + ":");
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student)) {
                System.out.println(enrollment.getCourse().getTitle());
            }
        }
    }

    // Thống kê khóa học có nhiều sinh viên nhất
    public static void courseWithMostStudents() {
        HashMap<String, Long> courseCounts = new HashMap<>();
        for (Enrollment enrollment : enrollments) {
            String courseId = enrollment.getCourse().getId();
            courseCounts.put(courseId, courseCounts.getOrDefault(courseId, 0L) + 1);
        }

        String mostPopularCourse = courseCounts.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        if (mostPopularCourse != null) {
            System.out.println("Khóa học có nhiều sinh viên nhất: " + mostPopularCourse);
        } else {
            System.out.println("Chưa có sinh viên đăng ký khóa học nào.");
        }
    }

    // Thống kê sinh viên đăng ký nhiều khóa học nhất
    public static void studentWithMostCourses() {
        HashMap<String, Long> studentCounts = new HashMap<>();
        for (Enrollment enrollment : enrollments) {
            String studentId = enrollment.getStudent().getId();
            studentCounts.put(studentId, studentCounts.getOrDefault(studentId, 0L) + 1);
        }

        String mostEnrolledStudent = studentCounts.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        if (mostEnrolledStudent != null) {
            System.out.println("Sinh viên đăng ký nhiều khóa học nhất: " + mostEnrolledStudent);
        } else {
            System.out.println("Chưa có sinh viên nào đăng ký khóa học.");
        }
    }
}

