package CompositePattern.bt2;

import java.util.ArrayList;
import java.util.List;

public class SubMenu implements MenuComponent {
    private String name;
    private List<MenuComponent> items = new ArrayList<>();

    public SubMenu(String name) {
        this.name = name;
    }

    public void add(MenuComponent item) {
        items.add(item);
    }

    public void remove(MenuComponent item) {
        items.remove(item);
    }

    @Override
    public void show(String indent) {
        System.out.println(indent + "+ " + name);
        for (MenuComponent item : items) {
            item.show(indent + "    ");
        }
    }
}
