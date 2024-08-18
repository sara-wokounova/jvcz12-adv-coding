package cz.sda.java.advcoding.ex20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class Rectangle extends Shape {
    private double a;
    private double b;


    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }

    @Override
    protected double calculateArea() {
        return a*b;
    }
}
