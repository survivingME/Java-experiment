/**
 * Created by Tremble on 2016/4/1.
 */
public class Rectangle extends GeometricObject {
    private double A ,B;
    public void setA(double A1) {
        this.A = A1;
    }
    public void setB(double B1) {
        this.B = B1;
    }
    public Rectangle(double A1, double B1) {
        this.A = A1;
        this.B = B1;
    }
    @Override
    public double showArea() {
        return A*B;
    }
}
