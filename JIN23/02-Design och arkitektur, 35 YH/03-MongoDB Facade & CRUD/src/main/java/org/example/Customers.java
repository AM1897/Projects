package org.example;

public class Customers extends Person {
    private String customersNumber;

    public Customers(String name, int age, String address, String customersNumber) {
        super(name, age, address);
        this.customersNumber = customersNumber;
    }
    public String getCustomersNumber() {
        return customersNumber;
    }
}
