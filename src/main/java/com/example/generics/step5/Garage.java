package com.example.generics.step5;

public class Garage<T extends Vehicle> {

    private T vehicle;

    public Garage() {
    }

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public T get() {
        return vehicle;
    }

    public void set(T vehicle) {
        this.vehicle = vehicle;
    }
}
