/**
 * Created by 15510 on 2016/3/8.
 */
public class FanTest {
    public static void main (String[] agrs) {
        Fan aFan = new Fan();
        Fan bFan = new Fan();
        aFan.setAll(3, true, 10, "yellow");
        bFan.setAll(2, false, 5, "blue");
        aFan.ToString();
        bFan.ToString();
    }
}
