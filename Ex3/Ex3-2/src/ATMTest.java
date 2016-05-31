/**
 * Created by 15510 on 2016/3/22.
 */
import java.util.Scanner;

public class ATMTest {
    public static void main(String[] agrs) {
        int i = 0;
        ATM[] userArray = new ATM[10];
        for(i = 0;i <= 9;i++) {
            userArray[i] = new ATM();
            userArray[i].setBalance(100);
        }


        //指定一个标签，当输入4时回到卡号输入
        label0:
        while(userArray[i] != null){
            System.out.println("请输入卡号（1位）：");
            Scanner cardNumber = new Scanner(System.in);
            if(cardNumber.nextInt()<0||cardNumber.nextInt()>9) {
                System.out.println("输入的卡号有错！");
                continue;
            }


            //指定一个标签，当操作完毕后回到主菜单
            label1:
            while(cardNumber.hasNextBoolean()) {
                System.out.println("\n主菜单\n1：查询余额\n2：取款\n3：存款\n4：退出\n请选择操作：");
                Scanner number = new Scanner(System.in);
                switch (number.nextInt()) {
                    case 1:
                        System.out.println("您的账户余额：" + userArray[cardNumber.nextInt()].getBalance());
                        break label1;
                    case 2:
                        System.out.println("请输入取款额：");
                        Scanner deposit = new Scanner(System.in);
                        userArray[cardNumber.nextInt()].deposit(deposit.nextInt());
                        break label1;
                    case 3:
                        System.out.println("请输入存款额：");
                        Scanner withdraw = new Scanner(System.in);
                        userArray[cardNumber.nextInt()].withDraw(withdraw.nextInt());
                        break label1;
                    case 4:break label0;
                }
            }
        }
    }
}
