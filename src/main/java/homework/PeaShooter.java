package homework;

public class PeaShooter extends GameObject implements Shooter {
    public PeaShooter(int x, int y) {
        super(100, x, y); // máu mặc định 100
    }

    @Override
    public void shoot(Zombie target) {
        System.out.println("PeaShooter bắn Zombie!");
        target.takeDamage(20);
    }

    @Override
    public void update() {
        System.out.println("PeaShooter ở vị trí (" + x + "," + y + "), máu: " + health);
    }
}
