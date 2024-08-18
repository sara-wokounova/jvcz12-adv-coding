package cz.sda.java.advcoding.ex15;

public enum Car {
    FERRARI(1000000, 350),
    PORSCHE(500000, 300),
    MERCEDES(300000, 250),
    BMW(200000, 200),
    OPEL(30000, 170),
    FIAT(20000,150),
    TOYOTA(40000, 190);

    private final int price;
    private final int maxSpeed;

    Car(int price, int maxSpeed) {
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public boolean isPremium() {
        return price > 100000;
    }

    public boolean isRegular() {
        return !isPremium();
    }

    public boolean isFasterThen(Car car) {
        return maxSpeed > car.maxSpeed;
    }
}
