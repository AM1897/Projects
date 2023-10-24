package se.dsve;

public class Truck extends Vehicle {
    private int doors;
    private int capacity;

    public Truck(String brand, String model, int speed, int year, int doors, int capacity, double fuelConsumption) {
        super(brand, model, speed, year, fuelConsumption);
        this.doors = doors;
        this.capacity = capacity;
    }

    public int getDoors() {
        return doors;
    }

    public int getCapacity() {
        return capacity;
    }
}