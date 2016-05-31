/**
 * Created by Tremble on 2016/4/1.
 */
class Circle extends GeometricObject {
    private double R;
    public void setR(double R1) {
        this.R = R1;
    }
    public Circle(double R1) {
        this.R = R1;
    }
    @Override
    public double showArea() {
        return R*R*3.1415926;
    }
}
