package org.training;

public class Circle extends Figure {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
