package com.example.generics.step7;

public class FixedSizedGarage<T extends Vehicle> {

    private final T[] vehicles;

    @SuppressWarnings("unchecked")
    public FixedSizedGarage(int size) {
        // vehicles = new T[size];
        vehicles = (T[]) new Vehicle[size];
    }

    public T get(int index) {
        return vehicles[index];
    }

    public void set(int index, T vehicle) {
        this.vehicles[index] = vehicle;
    }
}
