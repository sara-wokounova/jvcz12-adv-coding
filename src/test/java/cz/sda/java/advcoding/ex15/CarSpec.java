package cz.sda.java.advcoding.ex15;

import org.junit.jupiter.api.Test;

class CarSpec {

    @Test
    void checksIsPremium() {
        assert Car.FERRARI.isPremium();
        assert Car.PORSCHE.isPremium();
        assert Car.MERCEDES.isPremium();
        assert Car.BMW.isPremium();
        assert !Car.OPEL.isPremium();
        assert !Car.FIAT.isPremium();
        assert !Car.TOYOTA.isPremium();
    }

    @Test
    void checksIsRegular() {
        assert Car.OPEL.isRegular();
        assert Car.FIAT.isRegular();
        assert Car.TOYOTA.isRegular();
    }

    @Test
    void checksFasterThen() {
        assert Car.FERRARI.isFasterThen(Car.PORSCHE);
        assert Car.FERRARI.isFasterThen(Car.MERCEDES);
        assert Car.FERRARI.isFasterThen(Car.BMW);
    }
}
