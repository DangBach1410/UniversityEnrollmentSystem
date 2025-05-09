package bt2;

public abstract class Employee {
    protected String id;
    protected String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Salary: %.2f\n", id, name, calculateSalary());
    }
}
