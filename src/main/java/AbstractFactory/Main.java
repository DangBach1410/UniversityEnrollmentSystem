package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory lightFactory = new LightThemeFactory();
        Button lightButton = lightFactory.createButton();
        TextField lightTextField = lightFactory.createTextField();
        lightButton.render();
        lightTextField.render();

        UIFactory darkFactory = new DarkThemeFactory();
        Button darkButton = darkFactory.createButton();
        TextField darkTextField = darkFactory.createTextField();
        darkButton.render();
        darkTextField.render();
    }
}
