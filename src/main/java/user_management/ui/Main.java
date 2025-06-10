package user_management.ui;

import user_management.models.User;
import user_management.services.UserService;
import user_management.services.UserService;
import user_management.utils.InputUtil;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Tìm kiếm người dùng");
            System.out.println("4. Đổi mật khẩu");
            System.out.println("5. Danh sách người dùng");
            System.out.println("6. Xóa người dùng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = InputUtil.readInt();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> searchUser();
                case 4 -> changePassword();
                case 5 -> showAllUsers();
                case 6 -> deleteUser();
                case 0 -> System.out.println("Đã thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    private static void register() {
        System.out.println("\n=== ĐĂNG KÝ ===");
        User user = InputUtil.readUserInput();
        boolean success = userService.register(user);
        System.out.println(success ? "Đăng ký thành công." : "Đăng ký thất bại (email có thể đã tồn tại hoặc dữ liệu không hợp lệ).");
    }

    private static void login() {
        System.out.println("\n=== ĐĂNG NHẬP ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();

        User user = userService.login(email, password);
        if (user != null) {
            System.out.println("Đăng nhập thành công. Xin chào " + user.getFullName());
        } else {
            System.out.println("Sai email hoặc mật khẩu.");
        }
    }

    private static void searchUser() {
        System.out.println("\n=== TÌM KIẾM NGƯỜI DÙNG ===");
        System.out.print("Nhập tên hoặc email: ");
        String keyword = scanner.nextLine();
        List<User> users = userService.searchUser(keyword);
        if (users.isEmpty()) {
            System.out.println("Không tìm thấy người dùng nào.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void changePassword() {
        System.out.println("\n=== ĐỔI MẬT KHẨU ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Mật khẩu cũ: ");
        String oldPass = scanner.nextLine();
        System.out.print("Mật khẩu mới: ");
        String newPass = scanner.nextLine();

        boolean success = userService.changePassword(email, oldPass, newPass);
        System.out.println(success ? "Đổi mật khẩu thành công." : "Đổi mật khẩu thất bại. Mật khẩu cũ không đúng hoặc email không tồn tại.");
    }

    private static void showAllUsers() {
        System.out.println("\n=== DANH SÁCH NGƯỜI DÙNG ===");
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void deleteUser() {
        System.out.println("\n=== XÓA NGƯỜI DÙNG ===");
        System.out.print("Nhập email người dùng muốn xóa: ");
        String email = scanner.nextLine();
        boolean success = userService.deleteUser(email);
        System.out.println(success ? "Đã xóa người dùng." : "Không tìm thấy người dùng với email đó.");
    }
}
