package cz.sda.java.advcoding.ex21;

import org.junit.jupiter.api.Test;

class CubeSpec {

    @Test
    void calculatesVolume() {
        var cube = new Cube(3);
        assert cube.calculateVolume() == 27;
    }

    @Test
    void calculateArea() {
        var cube = new Cube(3);
        assert cube.calculateArea() == 54;
    }

    @Test
    void calculatesPerimeter() {
        var cube = new Cube(3);
        assert cube.calculatePerimeter() == 36;
    }
}
