package util;

public class Point implements Comparable<Point> {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point point) {
        return Double.compare(x, point.x);
    }

    public Point clone() {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return String.format("x = %.3f, y = %.3f", x, y);
    }
}
