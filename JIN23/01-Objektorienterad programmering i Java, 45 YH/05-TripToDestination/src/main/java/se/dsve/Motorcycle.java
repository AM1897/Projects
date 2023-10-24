package se.dsve;

public class Motorcycle extends Vehicle {
    private boolean windShield;

    public Motorcycle(String brand, String model, int speed, int year, boolean windShield, double fuelConsumption) {
        super(brand, model, speed, year, fuelConsumption);
        this.windShield = windShield;
    }

    public boolean hasWindShield() {
        return windShield;
    }
}