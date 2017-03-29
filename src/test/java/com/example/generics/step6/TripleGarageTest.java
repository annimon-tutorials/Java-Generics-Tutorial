package com.example.generics.step6;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class TripleGarageTest {

    private static final Car CAR = new Car("Aston Martin");
    private static final Motorcycle MOTORCYCLE = new Motorcycle("Honda CBR500R");
    private static final Truck TRUCK = new Truck("Road Kill");

    @Test
    public void testGarage() {
        TripleGarage<Car, Motorcycle, Truck> garage = new TripleGarage<>();
        garage.set1(CAR);
        garage.set2(MOTORCYCLE);
        garage.set3(TRUCK);

        assertThat(garage.get1(), instanceOf(Car.class));
        assertThat(garage.get2(), instanceOf(Motorcycle.class));
        assertThat(garage.get3(), instanceOf(Truck.class));
    }

    @Test
    public void testGarage2() {
        TripleGarage<Car, Motorcycle, Truck> garage = new TripleGarage<>();
        garage.set1(TRUCK);
        garage.set2(MOTORCYCLE);
        garage.set3(TRUCK);

        Car car1 = garage.get1();
//         Truck truck1 = garage.get1();

        assertThat(car1, instanceOf(Truck.class));
        assertThat(garage.get2(), instanceOf(Motorcycle.class));
        assertThat(garage.get3(), instanceOf(Truck.class));
    }

    @Test
    public void testGarage3() {
        TripleGarage<Car, Car, Car> garage = new TripleGarage<>();
        garage.set1(CAR);
        garage.set2(CAR);
        garage.set3(CAR);

        assertThat(garage.get1(), instanceOf(Car.class));
        assertThat(garage.get2(), instanceOf(Car.class));
        assertThat(garage.get3(), instanceOf(Car.class));
    }
}
