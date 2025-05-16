package ABSTRACT_FACTORY_PATTERN.bt7_8.Factories;

import ABSTRACT_FACTORY_PATTERN.bt7_8.MacWidgets.*;
import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.*;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Scrollbar createScrollbar() {
        return new MacScrollbar();
    }
}
