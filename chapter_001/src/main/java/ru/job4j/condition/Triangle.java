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


    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        double a = Point.distance(x1, y1, x3, y3); //distance is static method
        double b = Point.distance(x1, y1, x2, y2);
        double c = Point.distance(x3, y3, x2, y2);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }


}
