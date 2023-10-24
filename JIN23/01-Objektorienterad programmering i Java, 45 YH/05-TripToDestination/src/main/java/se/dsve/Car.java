package se.dsve;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, String model, int speed, int year, int doors, double fuelConsumption) {
        super(brand, model, speed, year, fuelConsumption);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }
}