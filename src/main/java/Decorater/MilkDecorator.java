package Decorater;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sữa";
    }
}

