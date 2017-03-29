package com.example.generics.step6;

public class TripleGarage<T extends Vehicle, U extends Vehicle, V extends Vehicle> {

    private T vehicle1;
    private U vehicle2;
    private V vehicle3;

    public TripleGarage() {
    }

    public T get1() {
        return vehicle1;
    }

    public void set1(T vehicle) {
        this.vehicle1 = vehicle;
    }

    public U get2() {
        return vehicle2;
    }

    public void set2(U vehicle) {
        this.vehicle2 = vehicle;
    }

    public V get3() {
        return vehicle3;
    }

    public void set3(V vehicle) {
        this.vehicle3 = vehicle;
    }
}
