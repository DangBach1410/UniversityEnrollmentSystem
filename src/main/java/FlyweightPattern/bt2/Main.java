package FlyweightPattern.bt2;

public class Main {
    public static void main(String[] args) {
        // Dòng văn bản: "ABC", mỗi ký tự có chung kiểu style
        String text = "ABC";

        // Style chung
        CharacterFlyweight style = CharacterFactory.getStyledCharacter("Arial", "Black", 12);

        for (int i = 0; i < text.length(); i++) {
            style.display(text.charAt(i), i, 1);
        }

        // Ký tự khác style
        CharacterFlyweight boldStyle = CharacterFactory.getStyledCharacter("Arial", "Black", 16);
        boldStyle.display('D', 3, 1);
    }
}

