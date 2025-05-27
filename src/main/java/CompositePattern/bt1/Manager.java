package CompositePattern.bt1;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "+ " + position + ": " + name);
        for (Employee e : subordinates) {
            e.showDetails(indent + "    ");
        }
    }
}

