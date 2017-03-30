package com.example.generics.step8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public <U> List<U> map(Function<T, U> function) {
        List<U> result = new ArrayList<>();
        for (T vehicle : vehicles) {
            result.add(function.apply(vehicle));
        }
        return result;
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T vehicle : vehicles) {
            consumer.accept(vehicle);
        }
    }

    // FIXME: <? super T> or <? extends T>
    public void fill(Supplier<T> supplier, int count) {
        for (int i = 0; i < count; i++) {
            vehicles.add(supplier.get());
        }
    }

    // FIXME: <? super T> or <? extends T>
    public void merge(DynamicSizedGarage<T> garage) {
        vehicles.addAll(garage.vehicles);
    }

    // FIXME: <? super T> or <? extends T>
    public void sort(Comparator<T> comparator) {
        vehicles.sort(comparator);
    }
}
