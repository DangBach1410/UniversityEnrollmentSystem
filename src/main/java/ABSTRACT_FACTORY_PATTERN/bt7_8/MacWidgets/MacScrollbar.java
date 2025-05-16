package ABSTRACT_FACTORY_PATTERN.bt7_8.MacWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Scrollbar;

public class MacScrollbar implements Scrollbar {
    @Override
    public void paint() {
        System.out.println("Vẽ scrollbar kiểu Mac.");
    }
}
