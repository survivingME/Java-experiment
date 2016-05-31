import java.util.ArrayList;
/**
 * Created by Tremble on 2016/4/1.
 */
public class SquareTest {
    public static void main(String[] agrs) {
        GeometricObject[]  geometricObject = new Square[5];
        for(int i = 0;i < 5;i++) {
            if(geometricObject[i] instanceof Square)
            {
                Square s = (Square) geometricObject[i];
                s.howToColor();
            }
        }
    }
}
