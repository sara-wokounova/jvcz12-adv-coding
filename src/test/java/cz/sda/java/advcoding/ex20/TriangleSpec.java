package cz.sda.java.advcoding.ex20;

import org.junit.jupiter.api.Test;

class TriangleSpec {

    @Test
    void calculatesPerimeter() {
        var triangle = new Triangle(3, 4, 5);
        assert triangle.calculatePerimeter() == 12;
    }

    @Test
    void calculatesArea() {
        var triangle = new Triangle(3, 4, 5);
        assert triangle.calculateArea() == 6;
    }
}
