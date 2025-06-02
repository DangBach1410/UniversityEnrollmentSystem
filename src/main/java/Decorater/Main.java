package Decorater;

public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new BasicCoffee();
        System.out.println(coffee1.getDescription() + " - " + coffee1.getCost() + " VNĐ");

        Coffee coffee2 = new MilkDecorator(new BasicCoffee());
        System.out.println(coffee2.getDescription() + " - " + coffee2.getCost() + " VNĐ");

        Coffee coffee3 = new SugarDecorator(new MilkDecorator(new BasicCoffee()));
        System.out.println(coffee3.getDescription() + " - " + coffee3.getCost() + " VNĐ");

        Coffee coffee4 = new CaramelDecorator(new SugarDecorator(new MilkDecorator(new BasicCoffee())));
        System.out.println(coffee4.getDescription() + " - " + coffee4.getCost() + " VNĐ");
    }
}

