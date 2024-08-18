package cz.sda.java.advcoding.ex21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
public class Cube extends Shape3D{
    private double a;


    @Override
    double calculateVolume() {
        return a * a * a;
    }

    @Override
    public double calculatePerimeter() {
        return 12 * a;
    }

    @Override
    protected double calculateArea() {
        return 6 * a * a;
    }
}
