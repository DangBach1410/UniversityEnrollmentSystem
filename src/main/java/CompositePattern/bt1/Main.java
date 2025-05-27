package CompositePattern.bt1;

public class Main {
    public static void main(String[] args) {
        Employee dev1 = new Developer("Alice");
        Employee dev2 = new Developer("Bob");
        Employee designer1 = new Designer("Clara");

        Manager techLead = new Manager("David", "Tech Lead");
        techLead.add(dev1);
        techLead.add(dev2);

        Manager designManager = new Manager("Eve", "Design Manager");
        designManager.add(designer1);

        Manager ceo = new Manager("Grace", "CEO");
        ceo.add(techLead);
        ceo.add(designManager);

        // In toàn bộ sơ đồ công ty
        ceo.showDetails("");
    }
}
