package com.example.generics.step6;

public abstract class Vehicle {

    protected final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
