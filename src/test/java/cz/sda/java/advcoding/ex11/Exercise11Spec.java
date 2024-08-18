package cz.sda.java.advcoding.ex11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise11Spec {

    @Test
    void resizeWorksAsExpected() {
        Circle circle = new Circle(new Point2D(0, 0), new Point2D(0,1));
        var factor = 5;
        var originalRadius = circle.getRadius();
        var originalArea = circle.getArea();
        var originalCircumference = circle.getCircumference();

        circle.resize(factor);

        assertEquals(originalRadius * factor, circle.getRadius());
        assertEquals(originalArea * factor * factor, circle.getArea());
        assertEquals(originalCircumference * factor, circle.getCircumference());
    }
}
