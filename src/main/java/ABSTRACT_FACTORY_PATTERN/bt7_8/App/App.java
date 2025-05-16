package ABSTRACT_FACTORY_PATTERN.bt7_8.App;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.*;

public class App {
    private Button button;
    private Checkbox checkbox;
    private Menu menu;
    private Scrollbar scrollbar;

    public App(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
        menu = factory.createMenu();
        scrollbar = factory.createScrollbar();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
        menu.paint();
        scrollbar.paint();
    }
}