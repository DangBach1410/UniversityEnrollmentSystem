package DecoratorPattern.bt1;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();                         // 20.0
        coffee = new SugarDecorator(coffee);                      // +2.0
        coffee = new MilkDecorator(coffee);                       // +3.0
        coffee = new CreamDecorator(coffee);                      // +4.0

        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total: " + coffee.getCost() + "k VND");
    }
}
