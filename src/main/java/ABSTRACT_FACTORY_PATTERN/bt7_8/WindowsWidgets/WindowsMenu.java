package ABSTRACT_FACTORY_PATTERN.bt7_8.WindowsWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Menu;

public class WindowsMenu implements Menu {
    @Override
    public void paint() {
        System.out.println("Vẽ menu kiểu Windows.");
    }
}