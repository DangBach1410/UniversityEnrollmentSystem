package FlyweightPattern.bt1;

public class Game {
    public static void main(String[] args) {
        // Tạo hàng loạt lính tại các vị trí khác nhau nhưng dùng chung dữ liệu

        Soldier soldier1 = SoldierFactory.getSoldier("Archer");
        soldier1.display(10, 20);

        Soldier soldier2 = SoldierFactory.getSoldier("Sniper");
        soldier2.display(30, 40);

        Soldier soldier3 = SoldierFactory.getSoldier("Archer"); // dùng lại object cũ
        soldier3.display(50, 60);

        Soldier soldier4 = SoldierFactory.getSoldier("Infantry");
        soldier4.display(70, 80);
    }
}

