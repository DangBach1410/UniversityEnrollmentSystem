package ABSTRACT_FACTORY_PATTERN.bt7_8.MacWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Vẽ nút bấm kiểu Mac.");
    }
}
