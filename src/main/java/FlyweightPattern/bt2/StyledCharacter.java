package FlyweightPattern.bt2;

public class StyledCharacter implements CharacterFlyweight {
    private String font;
    private String color;
    private int size;

    public StyledCharacter(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public void display(char character, int x, int y) {
        System.out.println("Character '" + character + "' at (" + x + ", " + y +
                ") with font: " + font + ", color: " + color + ", size: " + size);
    }
}

