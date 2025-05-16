package ABSTRACT_FACTORY_PATTERN.bt7_8.MacWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Menu;

public class MacMenu implements Menu {
    @Override
    public void paint() {
        System.out.println("Vẽ menu kiểu Mac.");
    }
}
