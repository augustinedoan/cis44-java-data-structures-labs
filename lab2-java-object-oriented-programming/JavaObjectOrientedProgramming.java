package com.mycompany.javaobjectorientedprogramming;

import java.util.Scanner;

// Step 1: Polygon interface
interface Polygon {
    double area();
    double perimeter();
}

// Quadrilateral base class
class Quadrilateral implements Polygon {
    protected double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return 0; // To be overridden
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }
}

// Rectangle subclass
class Rectangle extends Quadrilateral {
    protected double length, width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Square subclass
class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

// Triangle base class
class Triangle implements Polygon {
    protected double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

// Triangle subclasses
class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }
}

// Regular polygon classes
class Pentagon implements Polygon {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }

    @Override
    public double area() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }
}

class Hexagon implements Polygon {
    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }

    @Override
    public double area() {
        return (3 * Math.sqrt(3) * side * side) / 2;
    }
}

class Octagon implements Polygon {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }

    @Override
    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
}

// PolygonCalculator class (package-private)
class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polygon p = null;

        System.out.println("Choose shape:");
        System.out.println("1 Triangle");
        System.out.println("2 IsoscelesTriangle");
        System.out.println("3 EquilateralTriangle");
        System.out.println("4 Rectangle");
        System.out.println("5 Square");
        System.out.println("6 Pentagon");
        System.out.println("7 Hexagon");
        System.out.println("8 Octagon");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter three sides:");
                p = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
            }
            case 2 -> {
                System.out.println("Enter equal side and base:");
                p = new IsoscelesTriangle(scanner.nextDouble(), scanner.nextDouble());
            }
            case 3 -> {
                System.out.println("Enter side:");
                p = new EquilateralTriangle(scanner.nextDouble());
            }
            case 4 -> {
                System.out.println("Enter length and width:");
                p = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
            }
            case 5 -> {
                System.out.println("Enter side:");
                p = new Square(scanner.nextDouble());
            }
            case 6 -> {
                System.out.println("Enter side:");
                p = new Pentagon(scanner.nextDouble());
            }
            case 7 -> {
                System.out.println("Enter side:");
                p = new Hexagon(scanner.nextDouble());
            }
            case 8 -> {
                System.out.println("Enter side:");
                p = new Octagon(scanner.nextDouble());
            }
        }

        if (p != null) {
            System.out.println("Area: " + p.area());
            System.out.println("Perimeter: " + p.perimeter());
        }

        scanner.close();
    }
}

// Main public class matching the filename
public class JavaObjectOrientedProgramming {
    public static void main(String[] args) {
        // Call the polygon calculator
        PolygonCalculator.main(args);
    }
}
