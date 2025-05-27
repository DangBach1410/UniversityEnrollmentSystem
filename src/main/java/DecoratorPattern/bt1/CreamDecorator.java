package DecoratorPattern.bt1;

public class CreamDecorator extends CoffeeDecorator {
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Cream";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 4.0;
    }
}
