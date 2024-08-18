package cz.sda.java.advcoding.ex20;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@AllArgsConstructor
public class Hexagon {
    private double a;

    double calculatePerimeter() {
        return 6 * a;
    }

    double calculateArea() {
        return 3 * Math.sqrt(3) * a * a / 2;
    }
}
