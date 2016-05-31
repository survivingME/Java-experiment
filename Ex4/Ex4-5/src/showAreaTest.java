/**
 * Created by Tremble on 2016/4/1.
 */
public class showAreaTest {
    public static void main(String[] agrs) {
        GeometricObject[] aGeometricObject = new GeometricObject[4];
        aGeometricObject[0] = new Circle(1);
        aGeometricObject[1] = new Circle(2);
        aGeometricObject[2] = new Rectangle(1, 2);
        aGeometricObject[3] = new Rectangle(2, 3);
        double sumArea = 0;
        for(int i = 0;i <= 3;i++) {
            sumArea += aGeometricObject[i].showArea();
        }
        System.out.println("The total area is:"+sumArea);
    }
}
