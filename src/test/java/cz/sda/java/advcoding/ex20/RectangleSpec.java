package cz.sda.java.advcoding.ex20;

import org.junit.jupiter.api.Test;

class RectangleSpec {

    @Test
    void calculatesPerimeter() {
        var rectangle = new Rectangle(3, 4);
        assert rectangle.calculatePerimeter() == 14;
    }

    @Test
    void calculatesArea() {
        var rectangle = new Rectangle(3, 4);
        assert rectangle.calculateArea() == 12;
    }
}
