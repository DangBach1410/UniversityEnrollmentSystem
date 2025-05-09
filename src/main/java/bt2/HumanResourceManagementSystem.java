package bt2;

import java.util.ArrayList;

public class HumanResourceManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Thêm nhân viên full-time
        employees.add(new FullTimeEmployee("E001", "An", 10000000));
        employees.add(new FullTimeEmployee("E002", "Bình", 12000000));

        // Thêm nhân viên part-time
        employees.add(new PartTimeEmployee("E003", "Cường", 60, 80000));
        employees.add(new PartTimeEmployee("E004", "Dũng", 40, 90000));

        // Hiển thị danh sách nhân viên & tính tổng lương
        System.out.println("\nDanh sách nhân viên:");
        double totalSalary = 0;
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
            totalSalary += employees.get(i).calculateSalary();
        }

        System.out.printf("\nTổng lương công ty phải trả: %.2f\n", totalSalary);
    }
}
