package org.training;

public class Sphere {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double area() {
        return 4 * Math.pow(radius, 2) * Math.PI;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
