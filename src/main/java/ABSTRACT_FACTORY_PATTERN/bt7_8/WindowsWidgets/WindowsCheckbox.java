package ABSTRACT_FACTORY_PATTERN.bt7_8.WindowsWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Vẽ hộp chọn kiểu Windows.");
    }
}