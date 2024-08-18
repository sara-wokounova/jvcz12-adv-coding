package cz.sda.java.advcoding.ex13;

import cz.sda.java.advcoding.ex12.Car;
import cz.sda.java.advcoding.ex12.EngineType;
import cz.sda.java.advcoding.ex12.Manufacturer;
import lombok.NonNull;

import java.util.*;

class CarService {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCars(Collection<Car> cars) {
        this.cars.addAll(cars);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getAllCars() {
        return List.copyOf(cars);
    }

    public List<Car> getCarByEngineType(@NonNull EngineType engineType) {
        return cars.stream()
                .filter(car -> car.engineType().equals(engineType))
                .toList();
    }

    public List<Car> getCarsProducedBeforeYear(int year) {
        return cars.stream()
                .filter(car -> car.yearOfManufacture() < year)
                .toList();
    }

    public Car getMostExpensiveCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::price))
                .orElseThrow(() -> new IllegalStateException("No cars available"));
    }

//    public Car getCheapestCar() {
//        if (cars.isEmpty()) {
//            throw new IllegalStateException("No cars available");
//        }
//        Car cheapestCar = null;
//        for (Car car : cars) {
//            if (car.price() == null) {
//                continue;
//            }
//            if (cheapestCar == null) {
//                cheapestCar = car;
//            } else {
//                if (car.price().compareTo(cheapestCar.price()) < 0) {
//                    cheapestCar = car;
//                }
//            }
//        }
//        return Optional.ofNullable(cheapestCar)
//                .orElseThrow(() -> new IllegalStateException("No cars available"));
//    }

    public Car getCheapestCar() {
        return cars.stream()
                .filter(car -> car.price() != null)
                .min(Comparator.comparing(Car::price))
                .orElseThrow(() -> new IllegalStateException("No cars available"));
    }

    public List<Car> getByMinimumNumberOfManufacturers(int numberOfManufacturers) {
        return cars.stream()
                .filter(car -> car.manufacturers().size() >= numberOfManufacturers)
                .toList();
    }

    public List<Car> getSortedBy(SortAttribute sort) {
        return cars.stream()
                .sorted(getAttributeComparator(sort))
                .toList();
    }

    public boolean containsCar(Car car) {
        return cars.contains(car);
    }

    public List<Car> getCarsByManufacturer(Manufacturer manufacturer) {
        return cars.stream()
                .filter(car -> car.manufacturers().contains(manufacturer))
                .toList();
    }

    public List<Car> getCarsByManufacturersEstablishedYear(SelectionOperator operator, int year) {
        return cars.stream()
                .filter(car -> car.manufacturers().stream()
                        .map(Manufacturer::yearOfEstablishment)
                        .anyMatch(y -> operator.test(y, year)))
                .toList();
    }

    private Comparator<Car> getAttributeComparator(SortAttribute sort) {
        return switch (sort) {
            case name -> Comparator.comparing(Car::name);
            case model -> Comparator.comparing(Car::model);
            case price -> Comparator.comparing(Car::price);
            case yearOfManufacture -> Comparator.comparing(Car::yearOfManufacture);
            case engineType -> Comparator.comparing(Car::engineType);
        };
    }

}
