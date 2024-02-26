package org.training;

public class Cube {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    public double area() {
        return Math.pow(side, 2) * 6;
    }

    public double volume() {
        return Math.pow(side, 3);
    }
}
