/**
 * Created by Tremble on 2016/4/1.
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(40);
        if (c1.equals(c2)) {
            System.out.println("equal!");
        } else if (c1.compareTo(c2) < 0) {
            System.out.println(c2);
        } else if (c1.compareTo(c2) > 0) {
            System.out.println(c1);
        }
    }
}
