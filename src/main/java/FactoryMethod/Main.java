package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.createVehicle("car");
        Vehicle v2 = VehicleFactory.createVehicle("bike");
        Vehicle v3 = VehicleFactory.createVehicle("truck");

        v1.drive();
        v2.drive();
        v3.drive();
    }
}
