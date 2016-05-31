/**
 * Created by Tremble on 2016/4/1.
 */
public class ComparableCircleTest {
    public static void main(String[] agrs) {
        ComparableCircle a = new ComparableCircle();
        ComparableCircle b = new ComparableCircle();
        a.setR(1);
        a.setName("a");
        b.setR(2);
        b.setName("b");
        System.out.println("面积较大者为:"+a.compareTo(a, b));
    }
}
