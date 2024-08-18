package cz.sda.java.advcoding.ex13;

import cz.sda.java.advcoding.ex12.Car;
import cz.sda.java.advcoding.ex12.EngineType;
import cz.sda.java.advcoding.ex12.Manufacturer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

class CarServiceSpec {
    private static CarService carService;
    private static Set<Manufacturer> manufacturers;
    private static Car mostExpensiveCar;
    private static Car cheapestCar;

    @BeforeAll
    static void setup() {
        carService = new CarService();
        Manufacturer bmw = new Manufacturer("BMW", 1916, "Germany");
        Manufacturer volkswagen = new Manufacturer("Volkswagen", 1926, "Germany");
        Manufacturer mercedes = new Manufacturer("Mercedes", 1910, "Germany");
        manufacturers = Set.of(bmw, volkswagen, mercedes);
        carService.addCar(new Car("BMW", "X5", BigDecimal.valueOf(120000),  1998, Set.of(bmw), EngineType.V8));
        var a6 = new Car("Audi", "A6", BigDecimal.valueOf(150000), 2020, Set.of(volkswagen), EngineType.V6);
        var octavia = new Car("Skoda", "Octavia", BigDecimal.valueOf(30000), 2021, Set.of(volkswagen), EngineType.S4);
        mostExpensiveCar = a6;
        cheapestCar = octavia;
        carService.addCar(a6);
        carService.addCar(new Car("Mercedes", "S500", BigDecimal.valueOf(80000), 2021, Set.of(mercedes), EngineType.V12));
        carService.addCar(octavia);
        carService.addCar(new Car("Volkswagen", "Passat", BigDecimal.valueOf(40000), 2023, Set.of(volkswagen),EngineType.S3));
    }

    @Test
    void addsAndRemovesCarToList() {
        Manufacturer bmw = manufacturers.stream().filter(manufacturer -> manufacturer.name().equals("BMW")).findFirst().orElseThrow();
        Car car = new Car("BMW", "X3", BigDecimal.valueOf(100000),  2024, manufacturers, EngineType.V8);
        carService.addCar(car);
        assert carService.getAllCars().contains(car);
        carService.removeCar(car);
        assert !carService.getAllCars().contains(car);
    }

    @Test
    void getsCarByEngineType() {
        var cars = carService.getCarByEngineType(EngineType.V12);
        assert cars.size() == 1;
        assert cars.getFirst().engineType().equals(EngineType.V12);
    }

    @Test
    void getsCarsProducedBeforeYear() {
        var cars = carService.getCarsProducedBeforeYear(1999);
        assert cars.size() == 1;
        assert cars.stream().allMatch(car -> car.yearOfManufacture() < 1999);
    }

    @Test
    void getsMostExpensiveCar() {
        assert mostExpensiveCar == carService.getMostExpensiveCar();
    }

    @Test
    void getsCheapestCar() {
        assert cheapestCar == carService.getCheapestCar();
    }

    @Test
    void getsCarByNumberOfManufacturers() {
        var cars = carService.getByMinimumNumberOfManufacturers(3);
        assert cars.isEmpty();
    }

    @Test
    void getsCarsSortedByName() {
        var cars = carService.getSortedBy(SortAttribute.name);
        assert cars.getFirst().name().equals("Audi");
        assert cars.getLast().name().equals("Volkswagen");
    }

    @Test
    void checksIfCarIsContainedInList() {
        var car = carService.getAllCars().getFirst();
        assert carService.containsCar(car);
    }

    @Test
    void checksIfCarIsNotContainedInList() {
        Manufacturer bmw = manufacturers.stream().filter(manufacturer -> manufacturer.name().equals("BMW")).findFirst().orElseThrow();
        Car car = new Car("BMW", "X3", BigDecimal.valueOf(100000),  2024, manufacturers, EngineType.V8);
        assert !carService.containsCar(car);
    }

    @Test
    void getsListOfCarsByMasnufacturer() {
        var bmw = manufacturers.stream().filter(manufacturer -> manufacturer.name().equals("BMW")).findFirst().orElseThrow();
        var cars = carService.getCarsByManufacturer(bmw);
        assert cars.size() == 1;
        assert cars.getFirst().manufacturers().contains(bmw);
    }

    @Test
    void getsCarsByManufacturersYearOfEstabilishment() {
        var bmw = manufacturers.stream().filter(manufacturer -> manufacturer.name().equals("BMW")).findFirst().orElseThrow();
        var cars = carService.getCarsByManufacturersEstablishedYear(SelectionOperator.EQUALS, bmw.yearOfEstablishment());
        assert cars.size() == 1;
        assert cars.getFirst().manufacturers().contains(bmw);
    }
}
