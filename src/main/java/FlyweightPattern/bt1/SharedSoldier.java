package FlyweightPattern.bt1;

public class SharedSoldier implements Soldier {
    private String weapon;
    private String uniform;

    public SharedSoldier(String weapon, String uniform) {
        this.weapon = weapon;
        this.uniform = uniform;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Soldier at (" + x + ", " + y +
                ") with weapon: " + weapon + ", uniform: " + uniform);
    }
}
