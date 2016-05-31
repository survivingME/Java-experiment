/**
 * Created by Tremble on 2016/4/1.
 */
public class Circle extends GeometricObject implements Comparable {
    private double radius;
    public Circle() {
        super();
    }
    public Circle(double radius) {
        this();
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public String toString() {
        return super.toString() + " radius: " + radius;
    }
    @Override
    public boolean equals(Object arg0) {
        if (this.compareTo((Circle) arg0) == 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(Circle arg0) {
        return (int) Math.signum(this.getRadius() - arg0.getRadius());
    }
}