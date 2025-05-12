package homework;

public class Game {
    public static void main(String[] args) {
        PeaShooter peaShooter = new PeaShooter(5, 1);
        Zombie zombie = new Zombie(10, 1);

        int round = 1;

        while (zombie.isAlive() && zombie.x >= 0 && zombie.x > peaShooter.x) {
            System.out.println("\n--- Vòng " + round + " ---");

            // Update trạng thái
            peaShooter.update();
            zombie.update();

            // Nếu Zombie trong phạm vi 5 ô, cây bắn
            if (Math.abs(zombie.x - peaShooter.x) <= 5) {
                peaShooter.shoot(zombie);
            }

            round++;
        }

        System.out.println("\n--- Kết thúc trận chiến ---");
        if (!zombie.isAlive()) {
            System.out.println("Zombie đã bị tiêu diệt!");
        } else {
            System.out.println("Zombie đã vượt qua cây!");
        }
    }
}

