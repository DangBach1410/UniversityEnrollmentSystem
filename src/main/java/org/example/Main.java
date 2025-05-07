package org.example;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // Nhap so luong sinh vien n:
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());

        Student[] students = new Student[n];
        // Khai bao cac thong tin cua tung sinh vien
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < n; i++) {
            boolean validStudent = false;

            while (!validStudent) {
                System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

                // Nhập họ tên
                System.out.print("Họ tên: ");
                String fullname = sc.nextLine();

                // Nhập địa chỉ
                System.out.print("Địa chỉ: ");
                String address = sc.nextLine();

                // Nhập số điện thoại
                System.out.print("SĐT: ");
                String phone = sc.nextLine();

                // Nhập email
                System.out.print("Email: ");
                String email = sc.nextLine();

                // Nhập giới tính và kiểm tra hợp lệ
                boolean sex = false;
                System.out.print("Giới tính (true = Nam, false = Nữ): ");
                String inputSex = sc.nextLine().trim().toLowerCase();
                if (!inputSex.equals("true") && !inputSex.equals("false")) {
                    System.out.println("Giới tính không hợp lệ! Vui lòng nhập lại.");
                    continue;  // Yêu cầu nhập lại toàn bộ thông tin
                }
                sex = inputSex.equals("true");

                // Nhập ngày sinh và kiểm tra hợp lệ
                Date dob = null;
                System.out.print("Ngày sinh (dd/MM/yyyy): ");
                try {
                    dob = sdf.parse(sc.nextLine());
                } catch (ParseException e) {
                    System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập lại.");
                    continue;  // Yêu cầu nhập lại toàn bộ thông tin
                }

                // Nhập điểm và kiểm tra hợp lệ
                float grade = 0;
                System.out.print("Điểm: ");
                try {
                    grade = Float.parseFloat(sc.nextLine());
                    if (grade < 0 || grade > 10) {
                        System.out.println("Điểm không hợp lệ! Vui lòng nhập lại.");
                        continue;  // Yêu cầu nhập lại toàn bộ thông tin
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Điểm không hợp lệ! Vui lòng nhập lại.");
                    continue;  // Yêu cầu nhập lại toàn bộ thông tin
                }

                // Sau khi tất cả thông tin hợp lệ, tạo sinh viên mới
                String id = Integer.toString(i);  // Tạo id từ chỉ số i (hoặc có thể thay đổi theo yêu cầu)
                students[i] = new Student(id, fullname, address, phone, email, sex, dob, grade);
                validStudent = true;  // Thông tin sinh viên đã hợp lệ
            }
        }

        // Sap xep sinh vien theo do tuoi giam dan
        sortByAgeDescending(students);

        System.out.println("\nDanh sách sinh viên theo tuổi giảm dần:");
        for (Student s : students) {
            System.out.println(s.getFullname() + " - Ngày sinh: " + sdf.format(s.getDoB()));
        }
        // Sap xep sinh vien theo diem so tang dan
        sortByGradeAscending(students);

        System.out.println("\nDanh sách sinh viên theo điểm tăng dần:");
        for (Student s : students) {
            System.out.println(s.getFullname() + " - Điểm: " + s.getGrade());
        }
    }
    public static void sortByAgeDescending(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getDoB().after(students[j + 1].getDoB())) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
    public static void sortByGradeAscending(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getGrade() > students[j + 1].getGrade()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

}
