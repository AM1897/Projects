package se.dsve;

import static java.lang.System.*;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int speed;
    private int year;
    private double fuelConsumption;

    public Vehicle(String brand, String model, int speed, int year, double fuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    public double getFuelEfficiency() {
        return this.fuelConsumption;
    }

    public double getFuelConsumption(double distance) {
        return getFuelEfficiency() * distance / 100;
    }

    public void printDetails(double distance, double fuelPrice) {
        double fuelConsumptionForTrip = getFuelConsumption(distance);
        double fuelCost = fuelConsumptionForTrip * fuelPrice;

        out.println(getBrand() + " " + getModel() + " (" + getYear() + ")");
        out.println("Maximum speed is " + getMaxSpeed() + " km/h");
        out.println("Fuel efficiency is " + getFuelEfficiency() + " per 100 km");
        out.println("Fuel needed for the trip to Malmö is " + fuelConsumptionForTrip + " liters");
        out.println("Fuel cost for the entire trip is " + fuelCost + " SEK");
        out.println();
    }
}