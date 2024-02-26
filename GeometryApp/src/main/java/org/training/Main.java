package org.training;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        double resultCircleArea = circle.area();
        System.out.println("Площадь круга: " + resultCircleArea);
        System.out.println("Периметр круга: " + circle.perimeter());
        System.out.println("Площадь круга в миллиметрах: " + Calculation.toMillimeters(resultCircleArea));
        System.out.println("Площадь круга в метрах: " + Calculation.toMeters(resultCircleArea));
        System.out.println("Площадь круга в километрах - " + Calculation.toKilometers(resultCircleArea));
        System.out.println("----------------------------------------------------");

        Triangle triangle = new Triangle(3, 4, 5);
        double resultTriangleArea = triangle.area();
        System.out.println("Площадь треугольника: " + resultTriangleArea);
        System.out.println("Периметр треугольника: " + triangle.perimeter());
        System.out.println("Площадь треугольника в миллиметрах: " + Calculation.toMillimeters(resultTriangleArea));
        System.out.println("Площадь треугольника в метрах: " + Calculation.toMeters(resultTriangleArea));
        System.out.println("Площадь треугольника в километрах - " + Calculation.toKilometers(resultTriangleArea));
        System.out.println("----------------------------------------------------");

        Rectangle rectangle = new Rectangle(7, 4);
        double resultRectangleArea = rectangle.area();
        System.out.println("Площадь прямоугольника: " + resultRectangleArea);
        System.out.println("Периметр прямоугольника: " + rectangle.perimeter());
        System.out.println("Площадь прямоугольника в миллиметрах: " + Calculation.toMillimeters(resultRectangleArea));
        System.out.println("Площадь прямоугольника в метрах: " + Calculation.toMeters(resultRectangleArea));
        System.out.println("Площадь прямоугольника в километрах - " + Calculation.toKilometers(resultRectangleArea));
        System.out.println("----------------------------------------------------");

        Cube cube = new Cube(7);
        System.out.println("Площадь куба: " + cube.area());
        System.out.println("Объем куба: " + cube.volume());
        System.out.println("----------------------------------------------------");

        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("Площадь цилиндра: " + cylinder.area());
        System.out.println("Объем цилиндра: " + cylinder.volume());
        System.out.println("----------------------------------------------------");

        Sphere sphere = new Sphere(8);
        System.out.println("Площадь сферы: " + sphere.area());
        System.out.println("Объем сферы: " + sphere.volume());
    }
}