package cz.sda.java.advcoding.ex21;

import cz.sda.java.advcoding.ex20.Shape;
import cz.sda.java.advcoding.ex22.Fillable;

abstract class Shape3D extends Shape implements Fillable {
    abstract double calculateVolume();

    @Override
    public void fill(double volume) {
        var difference = calculateVolume() - volume;
        if (difference > 0) {
            System.out.println("Not enough volume to fill");
        } else if (difference == 0) {
            System.out.println("Filled to the brim");
        } else {
            System.out.println("Overflowed.");
        }

    }
}
