package cz.sda.java.advcoding.ex21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cone extends Shape3D{
    private double radius;
    private double height;


    @Override
    double calculateVolume() {
        return 1.0 / 3.0 * Math.PI * radius * radius * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
    }
}
