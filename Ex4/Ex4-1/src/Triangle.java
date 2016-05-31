/**
 * Created by Tremble on 2016/4/1.
 */
public class Triangle extends  GeometricObject {
    private double a, b, c;

    public void setA(double a1) {
        this.a = a1;
    }
    public void setB(double b1) {
        this.b = b1;
    }
    public void setC(double c1) {
        this.c = c1;
    }
    public double showArea() {
        double d = (a+b+c)/2;
        return Math.sqrt(d*(d-a)*(d-b)*(d-c));
    }

}
