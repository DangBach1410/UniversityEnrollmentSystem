package ABSTRACT_FACTORY_PATTERN.bt7_8.Factories;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.*;
import ABSTRACT_FACTORY_PATTERN.bt7_8.WindowsWidgets.*;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Scrollbar createScrollbar() {
        return new WindowsScrollbar();
    }
}

