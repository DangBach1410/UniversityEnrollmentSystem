package ABSTRACT_FACTORY_PATTERN.bt7_8.MacWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Vẽ hộp chọn kiểu Mac.");
    }
}
