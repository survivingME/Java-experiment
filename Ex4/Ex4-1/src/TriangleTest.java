import java.util.Scanner;
/**
 * Created by Tremble on 2016/4/1.
 */
public class TriangleTest {
    public static void main(String[] agrs) {
        double a, b, c;
        String d;
        boolean e;
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the three sides of the triangle:\na:");
        a = in.nextDouble();
        System.out.println("b:");
        b = in.nextDouble();
        System.out.println("c:");
        c = in.nextDouble();
        System.out.println("Please input the color of the triangle:");
        d = in.next();
        System.out.println("Please input the boolean of filled:");
        e = in.hasNext();

        Triangle aTriangle = new Triangle();
        aTriangle.setA(a);
        aTriangle.setB(b);
        aTriangle.setC(c);
        aTriangle.setColor(d);
        aTriangle.setFilled(e);

        System.out.println("Area:"+aTriangle.showArea()+"\nPerimeter:"+(a+b+c)+
                "\nColor:"+aTriangle.getColor());
        if (aTriangle.getFilled() == true) {
            System.out.println("Filled:Yes");
        } else {
            System.out.println("Filled:No");
        }
    }
}
