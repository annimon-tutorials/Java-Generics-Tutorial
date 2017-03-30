package com.example.generics.step8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
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

    @Test
    public void testForEach2() {
        Consumer<Object> objectConsumer = object -> System.out.println(object.hashCode());
        Consumer<Vehicle> vehicleConsumer = vehicle -> System.out.println(vehicle.getName());

        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Toyota"));
        garage.add(new Car("Jaguar"));
        garage.add(new Car("BMW"));
        garage.forEach(vehicleConsumer);
        garage.forEach(objectConsumer);
    }

    @Test
    public void testReplaceAll() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("Toyota"));
        garage.add(new Car("Jaguar"));
        garage.add(new Car("BMW"));

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Aston Martin"));
        cars.add(new Car("Audi"));

        garage.replaceWith(cars);

        assertThat(garage.get(0).getName(), is("Aston Martin"));
        assertThat(garage.get(1).getName(), is("Audi"));
        assertThat(garage.get(2).getName(), is("BMW"));


        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck("Terminator"));

        garage.replaceWith(trucks);

        assertThat(garage.get(0).getName(), is("Terminator"));
        assertThat(garage.get(1).getName(), is("Audi"));
        assertThat(garage.get(2).getName(), is("BMW"));
    }

    @Test
    public void testFilter() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("BMW M6"));
        garage.add(new Car("Jaguar XJ"));
        garage.add(new Car("Aston Martin DB11"));
        garage.add(new Car("Jaguar XF"));
        garage.add(new Car("Aston Martin Rapide S"));
        garage.add(new Car("Aston Martin Vanquish"));
        garage.add(new Car("Toyota Corolla"));

        List<Car> cars = garage.filter(c -> c.getName().startsWith("Aston Martin"));
        assertThat(cars.size(), is(3));
        assertThat(cars.get(0).getName(), is("Aston Martin DB11"));
        assertThat(cars.get(1).getName(), is("Aston Martin Rapide S"));
        assertThat(cars.get(2).getName(), is("Aston Martin Vanquish"));

        Predicate<Vehicle> jaguarFilter = v -> v.getName().startsWith("Jaguar");
        List<Car> jaguars = garage.filter(jaguarFilter);
        assertThat(jaguars.size(), is(2));
        assertThat(jaguars.get(0).getName(), is("Jaguar XJ"));
        assertThat(jaguars.get(1).getName(), is("Jaguar XF"));
    }

    @Test
    public void testFill() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.fill(() -> new Car("BMW"), 2);

        assertThat(garage.get(0).getName(), is("BMW"));
        assertThat(garage.get(1).getName(), is("BMW"));
    }

    @Test
    public void testMerge() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("BMW M6"));
        garage.add(new Car("Jaguar XJ"));

        DynamicSizedGarage<Car> garage2 = new DynamicSizedGarage<>();
        garage2.add(new Car("Aston Martin DB11"));
        garage2.add(new Car("Toyota Corolla"));

        garage.merge(garage2);

        assertThat(garage.get(0).getName(), is("BMW M6"));
        assertThat(garage.get(1).getName(), is("Jaguar XJ"));
        assertThat(garage.get(2).getName(), is("Aston Martin DB11"));
        assertThat(garage.get(3).getName(), is("Toyota Corolla"));
    }

    @Test
    public void testSort() {
        DynamicSizedGarage<Car> garage = new DynamicSizedGarage<>();
        garage.add(new Car("BMW M6"));
        garage.add(new Car("Jaguar XJ"));
        garage.add(new Car("Aston Martin DB11"));
        garage.add(new Car("Toyota Corolla"));

        garage.sort(Comparator.comparing(Car::getName));

        assertThat(garage.get(0).getName(), is("Aston Martin DB11"));
        assertThat(garage.get(1).getName(), is("BMW M6"));
        assertThat(garage.get(2).getName(), is("Jaguar XJ"));
        assertThat(garage.get(3).getName(), is("Toyota Corolla"));
    }
}
