package homework;

public class Zombie extends GameObject implements Mover {
    public Zombie(int x, int y) {
        super(60, x, y); // máu mặc định 60
    }

    @Override
    public void move() {
        x -= 1;
    }

    @Override
    public void update() {
        move();
        System.out.println("Zombie di chuyển đến vị trí (" + x + "," + y + "), máu: " + health);
    }
}
