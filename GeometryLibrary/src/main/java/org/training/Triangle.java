package org.training;

public class Triangle extends Figure {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double pp = (a + b + c) / 2;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
