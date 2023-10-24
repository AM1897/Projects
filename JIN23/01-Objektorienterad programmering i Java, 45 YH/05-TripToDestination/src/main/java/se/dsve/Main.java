package se.dsve;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        double distance = 200;
        double fuelPrice = 19.42;

        out.println("Traveling to Malmö is " + distance + " km: ");
        out.println("Fuel price is " + fuelPrice + " SEK");
        out.println();

        Car car = new Car("BMW", "M5", 260, 2022, 4, 10.0);
        car.printDetails(distance, fuelPrice);

        Motorcycle motorcycle = new Motorcycle("Yamaha", "MT-07", 310, 2019, false, 4.5);
        motorcycle.printDetails(distance, fuelPrice);

        Truck truck = new Truck("Mercedes-Benz", "Actros", 110, 2015, 2, 80, 36.0);
        truck.printDetails(distance, fuelPrice);


        double carCost = car.getFuelConsumption(distance) * fuelPrice;
        double motorcycleCost = motorcycle.getFuelConsumption(distance) * fuelPrice;
        double truckCost = truck.getFuelConsumption(distance) * fuelPrice;

        out.println("Cost comparison for the trip to Malmö:");
        out.println("Car: " + carCost + " SEK");
        out.println("Motorcycle: " + motorcycleCost + " SEK");
        out.println("Truck: " + truckCost + " SEK");
        out.println();

        if (carCost < motorcycleCost && carCost < truckCost) {
            out.println("The car is the cheapest option for this trip.");
        } else if (motorcycleCost < carCost && motorcycleCost < truckCost) {
            out.println("The motorcycle is the cheapest option for this trip.");
        } else {
            out.println("The truck is the cheapest option for this trip.");
        }
    }
}
