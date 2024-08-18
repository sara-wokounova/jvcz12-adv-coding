package cz.sda.java.advcoding.ex20;

import org.junit.jupiter.api.Test;

class HexagonSpec {
    @Test
    void calculatesPerimeter() {
        var hexagon = new Hexagon(3);
        assert hexagon.calculatePerimeter() == 18;
    }

    @Test
    void calculatesArea() {
        var hexagon = new Hexagon(3);
        assert Math.round(hexagon.calculateArea() * 100) == 2338;
    }
}
