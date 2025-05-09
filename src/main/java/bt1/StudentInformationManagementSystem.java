package bt1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentInformationManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        // Nhập danh sách sinh viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Tên: ");
            String name = sc.nextLine();
            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            students.add(new Student(id, name, age, gpa));
        }

        System.out.println("\nDanh sách sinh viên có GPA >= 3.2:");
        for (Student s : students) {
            if (s.getGpa() >= 3.2) {
                System.out.println(s);;
            }
        }

        // Sắp xếp theo GPA giảm dần
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getGpa() < students.get(j + 1).getGpa()) {
                    // Hoán đổi vị trí sinh viên j và j+1
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo GPA giảm dần:");
        for (Student s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
