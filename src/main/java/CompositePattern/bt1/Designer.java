package CompositePattern.bt1;

public class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name) {
        this.name = name;
        this.position = "Designer";
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- " + position + ": " + name);
    }
}
