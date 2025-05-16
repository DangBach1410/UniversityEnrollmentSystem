package ABSTRACT_FACTORY_PATTERN.bt7_8.App;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.GUIFactory;
import ABSTRACT_FACTORY_PATTERN.bt7_8.Factories.*;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        App app = new App(factory);
        app.paint();
    }
}
