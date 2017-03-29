package com.example.generics.step8;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DynamicSizedGarageTest {

    @Test
    public void testCar() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Aston Martin"));
        Car car = garage.get(0);
        assertThat(car.getName(), is("Aston Martin"));
    }

    @Test
    public void testGarages() {
        DynamicSizedGarage<Car> garage1 = new DynamicSizedGarage<>();
        garage1.add(new Car("Aston Martin"));
        garage1.add(new Car("Audi"));

        DynamicSizedGarage<Motorcycle> garage2 = new DynamicSizedGarage<>();
        garage2.add(new Motorcycle("Honda CBR500R"));
        garage2.add(new Motorcycle("Harley-Davidson"));

        Car car1 = garage1.get(0);
        Car car2 = garage1.get(1);
        assertThat(car1.getName(), is("Aston Martin"));
        assertThat(car2.getName(), is("Audi"));

        Motorcycle motorcycle1 = garage2.get(0);
        Motorcycle motorcycle2 = garage2.get(1);
        assertThat(motorcycle1.getName(), is("Honda CBR500R"));
        assertThat(motorcycle2.getName(), is("Harley-Davidson"));
    }

    @Test
    public void testAddAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota"));
        cars.add(new Car("Jaguar"));
        cars.add(new Car("BMW"));

        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Aston Martin"));
        garage.addAll(cars);

        assertThat(garage.get(2).getName(), is("Jaguar"));
        assertThat(garage.get(3).getName(), is("BMW"));
    }

    @Test
    public void testAddAll2() {
        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck("Hell yeah"));
        trucks.add(new Truck("Terminator"));

        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Aston Martin"));
        garage.addAll(trucks);

        assertThat(garage.get(1).getName(), is("Hell yeah"));
        assertThat(garage.get(2).getName(), is("Terminator"));
    }

    @Test
    public void testForEach() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Toyota"));
        garage.add(new Car("Jaguar"));
        garage.add(new Car("BMW"));
        garage.forEach(car -> System.out.println(car.getName()));
    }
}
