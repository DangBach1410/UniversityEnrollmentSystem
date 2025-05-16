package FACTORY_METHOD_PATTERN.bt4;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw(); // Output: Vẽ hình tròn.

        Shape shape2 = ShapeFactory.getShape("square");
        shape2.draw(); // Output: Vẽ hình vuông.
    }
}

