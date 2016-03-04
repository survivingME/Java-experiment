import java.util.Random;

public class randomAPI {
    public void showRandomNumer() {
        Random r = new Random(1000);
        for(int i = 0;i < 5;i++) {
            System.out.println();
            for(int j = 0;j < 10;j++) {
                System.out.print(r.nextInt(100) + " ");
            }
        }
    }
}
