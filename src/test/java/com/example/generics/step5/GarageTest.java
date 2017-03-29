package com.example.generics.step5;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GarageTest {

    @Test
    public void testCar() {
        Garage<Car> garage = new Garage<>();
        garage.set(new Car("Aston Martin"));
        Car car = garage.get();
        assertThat(car.getName(), is("Aston Martin"));
    }

    @Test
    public void testGarages() {
        Garage<Car> garage1 = new Garage<>();
        Garage<Motorcycle> garage2 = new Garage<>();
        garage1.set(new Car("Aston Martin"));
        garage2.set(new Motorcycle("Honda CBR500R"));

        Car car = garage1.get();
        Motorcycle motorcycle = garage2.get();
        assertThat(car.getName(), is("Aston Martin"));
        assertThat(motorcycle.getName(), is("Honda CBR500R"));
    }

    @Test
    public void testJupiter() {
        // Error: type argument Jupiter is not within bounds of type-variable T
//        Garage<Jupiter> garage = new Garage<>();
//        garage.set(new Jupiter());
//        Jupiter jupiter = garage.get();
//        assertThat(jupiter.getClass().getSimpleName(), is("Jupiter"));
    }
}
