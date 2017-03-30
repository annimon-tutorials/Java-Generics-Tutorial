package com.example.generics.step8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DynamicSizedGarage<T extends Vehicle> {

    private final List<T> vehicles;

    public DynamicSizedGarage() {
        vehicles = new ArrayList<>();
    }

    public void add(T t) {
        vehicles.add(t);
    }

    public void addAll(List<? extends T> list) {
        vehicles.addAll(list);
    }

    public T get(int index) {
        return vehicles.get(index);
    }

    public void replaceWith(List<? extends T> list) {
        final int listSize = list.size();
        final int size = vehicles.size();
        vehicles.subList(0, Math.min(listSize, size)).clear();
        vehicles.addAll(0, list);
    }

    public List<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T vehicle : vehicles) {
            if (predicate.test(vehicle)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T vehicle : vehicles) {
            consumer.accept(vehicle);
        }
    }
}
