package FlyweightPattern.bt2;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static final Map<String, CharacterFlyweight> flyweightMap = new HashMap<>();

    public static CharacterFlyweight getStyledCharacter(String font, String color, int size) {
        String key = font + "-" + color + "-" + size;

        if (!flyweightMap.containsKey(key)) {
            flyweightMap.put(key, new StyledCharacter(font, color, size));
        }

        return flyweightMap.get(key);
    }
}

