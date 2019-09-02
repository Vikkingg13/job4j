package ru.job4j.condition;

public class Triangle {

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


    public double area(Point first, Point second, Point third) {
        double result = -1;
        double a = first.distance(third); //distance is static method
        double b = second.distance(first);
        double c = third.distance(second);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }


}
