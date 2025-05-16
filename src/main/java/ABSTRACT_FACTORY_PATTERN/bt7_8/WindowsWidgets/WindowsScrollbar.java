package ABSTRACT_FACTORY_PATTERN.bt7_8.WindowsWidgets;

import ABSTRACT_FACTORY_PATTERN.bt7_8.Interfaces.Scrollbar;

public class WindowsScrollbar implements Scrollbar {
    @Override
    public void paint() {
        System.out.println("Vẽ scrollbar kiểu Windows.");
    }
}
