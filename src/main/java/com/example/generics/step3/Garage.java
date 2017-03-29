package com.example.generics.step3;

public class Garage {

    private Vehicle vehicle;

    public Garage() {
    }

    public Garage(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle get() {
        return vehicle;
    }

    public void set(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
