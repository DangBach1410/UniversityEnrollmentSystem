package AbstractFactory;

public class LightThemeFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public TextField createTextField() {
        return new LightTextField();
    }
}
