package FlyweightPattern.bt1;

import java.util.HashMap;
import java.util.Map;

public class SoldierFactory {
    private static final Map<String, Soldier> soldierMap = new HashMap<>();

    public static Soldier getSoldier(String type) {
        Soldier soldier = soldierMap.get(type);

        if (soldier == null) {
            // Giả sử "type" là kiểu lính: Archer, Sniper, Infantry...
            switch (type) {
                case "Archer":
                    soldier = new SharedSoldier("Bow", "Green");
                    break;
                case "Sniper":
                    soldier = new SharedSoldier("Rifle", "Black");
                    break;
                case "Infantry":
                    soldier = new SharedSoldier("Sword", "Brown");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown soldier type: " + type);
            }
            soldierMap.put(type, soldier);
        }

        return soldier;
    }
}

