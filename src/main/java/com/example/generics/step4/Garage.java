package com.example.generics.step4;

public class Garage<T> {

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
