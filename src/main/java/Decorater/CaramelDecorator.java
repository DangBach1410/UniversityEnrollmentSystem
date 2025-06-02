package Decorater;

public class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 7000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Caramel";
    }
}
