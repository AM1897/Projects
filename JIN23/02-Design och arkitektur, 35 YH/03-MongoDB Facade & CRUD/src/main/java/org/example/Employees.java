package org.example;

public class Employees extends Person{
    private String employeesNumber;

    public Employees(String name, int age, String address, String employeesNumber) {
        super(name, age, address);
        this.employeesNumber = employeesNumber;
    }
    public String getEmployeesNumber() {
        return employeesNumber;
    }
}