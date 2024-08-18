package cz.sda.java.advcoding.ex20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    @Override
    public double calculatePerimeter() {
        return a+b+c;
    }

    @Override
    protected double calculateArea() {
        var s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
