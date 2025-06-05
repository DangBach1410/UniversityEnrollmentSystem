package bt1;

public class Main {
    public static void main(String[] args) {
        Publisher page = new Publisher("Trang của Hoa");

        User user1 = new User("Nam");
        User user2 = new User("Linh");

        page.subscribe(user1);
        page.subscribe(user2);

        page.post("Chào mọi người! Đây là bài đăng đầu tiên.");
    }
}
