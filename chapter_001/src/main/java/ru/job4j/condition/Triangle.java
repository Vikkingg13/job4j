package ru.job4j.condition;

public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    private boolean exist(double a, double b, double c) {
        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }
            return result;
        }


    public double area() {
        double result = -1;
        double a = first.distance(third);
        double b = second.distance(first);
        double c = third.distance(second);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }


}
