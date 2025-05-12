package bt7;

import java.util.ArrayList;
import java.util.List;

class BattleField {
    private static List<Fighter> fighters = new ArrayList<>();

    public static void main(String[] args) {

        addFighter(new Knight("Arthur"));
        addFighter(new Archer("Robin"));
        addFighter(new Mage("Merlin"));

        startBattle(17); // Mỗi chiến binh đánh 5 lượt
    }

    public static void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public static void startBattle(int rounds) {
        System.out.println("=== Battle Starts ===");
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n-- Round " + i + " --");
            for (Fighter f : fighters) {
                f.attack();
            }
        }
        System.out.println("\n=== Battle Ends ===");
    }
}
