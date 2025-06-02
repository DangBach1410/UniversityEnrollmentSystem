package Decorater;

public class BasicCoffee implements Coffee {
    @Override
    public double getCost() {
        return 20000; // Giá cà phê cơ bản
    }

    @Override
    public String getDescription() {
        return "Cà phê cơ bản";
    }
}

