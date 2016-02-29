import java.util.Random;
/**
 * Created by Tremble on 2016/2/28.
 */
public class API {
    public  void showRandomNumer() {
        Random r = new Random(1000);
        for(int i = 0;i < 5;i++) {
            System.out.println();
            for(int j = 0;j < 10;j++) {
                System.out.print(r.nextInt(100) + " ");
            }
        }
    }

    public static void main(String[] agrs) {
        API case1 = new API();
        case1.showRandomNumer();
    }

}

