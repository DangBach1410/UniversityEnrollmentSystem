package CompositePattern.bt1;

public class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name) {
        this.name = name;
        this.position = "Developer";
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "- " + position + ": " + name);
    }
}
