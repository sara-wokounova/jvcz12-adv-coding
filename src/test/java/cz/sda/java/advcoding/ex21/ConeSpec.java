package cz.sda.java.advcoding.ex21;

import org.junit.jupiter.api.Test;

class ConeSpec {
    @Test
    void calculatesVolume() {
        var cone = new Cone(3, 4);
        assert Math.round(cone.calculateVolume() * 100) == 3770;
    }

    @Test
    void calculatesArea() {
        var cone = new Cone(3, 4);
        assert Math.round(cone.calculateArea() * 100) == 7540;
    }

    @Test
    void calculatesPerimeter() {
        var cone = new Cone(3, 4);
        assert Math.round(cone.calculatePerimeter() * 100) == 1885;
    }
}
