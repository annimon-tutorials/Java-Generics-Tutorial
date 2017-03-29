package com.example.generics.step7;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixedSizedGarageTest {

    @Test
    public void testCar() {
        FixedSizedGarage<Car> garage = new FixedSizedGarage<>(1);
        garage.set(0, new Car("Aston Martin"));
        Car car = garage.get(0);
        assertThat(car.getName(), is("Aston Martin"));
    }

    @Test
    public void testGarages() {
        FixedSizedGarage<Car> garage1 = new FixedSizedGarage<>(2);
        garage1.set(0, new Car("Aston Martin"));
        garage1.set(1, new Car("Audi"));

        FixedSizedGarage<Motorcycle> garage2 = new FixedSizedGarage<>(2);
        garage2.set(0, new Motorcycle("Honda CBR500R"));
        garage2.set(1, new Motorcycle("Harley-Davidson"));

        Car car1 = garage1.get(0);
        Car car2 = garage1.get(1);
        assertThat(car1.getName(), is("Aston Martin"));
        assertThat(car2.getName(), is("Audi"));

        Motorcycle motorcycle1 = garage2.get(0);
        Motorcycle motorcycle2 = garage2.get(1);
        assertThat(motorcycle1.getName(), is("Honda CBR500R"));
        assertThat(motorcycle2.getName(), is("Harley-Davidson"));
    }
}
