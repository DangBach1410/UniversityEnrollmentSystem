package Decorater;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Đường";
    }
}

