package org.training;

public class Cylinder {
    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double area() {
        double baseArea = Math.pow(height, 2) * Math.PI;
        double lateralArea = 2 * Math.PI * radius * height;
        return 2 * baseArea + lateralArea;
    }

    public double volume() {
        return Math.pow(radius, 2) * height * Math.PI;
    }
}
