package user_management.utils;

import user_management.models.User;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
            }
        }
    }

    public static User readUserInput() {
        User user = new User();
        System.out.print("Họ tên: ");
        user.setFullName(scanner.nextLine());

        System.out.print("Email: ");
        user.setEmail(scanner.nextLine());

        System.out.print("Mật khẩu: ");
        user.setPassword(scanner.nextLine());

        System.out.print("Số điện thoại: ");
        user.setPhone(scanner.nextLine());

        System.out.print("Địa chỉ: ");
        user.setAddress(scanner.nextLine());

        System.out.print("Ngày sinh (YYYY-MM-DD): ");
        user.setBirthDay(LocalDate.parse(scanner.nextLine()));

        System.out.print("Vai trò (admin/user): ");
        user.setRole(scanner.nextLine());

        return user;
    }
}

