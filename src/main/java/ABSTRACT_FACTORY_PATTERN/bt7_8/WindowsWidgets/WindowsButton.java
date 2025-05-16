package ABSTRACT_FACTORY_PATTERN.bt7_8.WindowsWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Vẽ nút bấm kiểu Windows.");
    }
}
