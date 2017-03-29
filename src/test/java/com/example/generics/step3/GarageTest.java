package com.example.generics.step3;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GarageTest {

    @Test
    public void testCar() {
        Garage garage = new Garage();
        garage.set(new Car("Aston Martin"));
        Car car = (Car) garage.get();
        assertThat(car.getName(), is("Aston Martin"));
    }

    @Test(expected = ClassCastException.class)
    public void testGarages() {
        Garage garage1 = new Garage();
        Garage garage2 = new Garage();
        garage1.set(new Car("Aston Martin"));
        garage2.set(new Motorcycle("Honda CBR500R"));

        Car car = (Car) garage1.get();
        Motorcycle motorcycle = (Motorcycle) garage1.get();
        assertThat(car.getName(), is("Aston Martin"));
        assertThat(motorcycle.getName(), is("Honda CBR500R"));
    }
}
