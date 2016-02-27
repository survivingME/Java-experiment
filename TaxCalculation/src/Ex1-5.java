import java.util.Scanner;
/**
 * Created by Tremble on 2016/2/27.
 */
public class TaxList {
    int type;
    long income;
    double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
    int[][] brackets = {
            {8350, 33950, 82250, 171550, 372950},
            {16700, 67900, 137050, 208850, 372950},
            {8350, 33950, 68525, 104425, 186475},
            {11950, 45500, 117450, 190200, 372950}
    };

    public void showType() {
        System.out.print("<0-单身纳税人，1-已婚共同纳税人或证实的孤寡，2-已婚单独纳税人，3-家庭户主纳税人>\n");
    }
    public void getType () {
        System.out.print("\nEnter the filing status:");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        type = Integer.parseInt(input);
        if (type < 0 && type > 3) {
            System.out.println("Please input valid number!");
            System.exit(0);
        }
    }
    public void getIncome() {
        System.out.print("Enter the taxable income:");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        income = Integer.parseInt(input);
        if (income < 0) {
            System.out.println("Please input valid income!");
            System.exit(0);
        }
    }
    public void tax() {
        if (0 <= type && type <= 3) {
            if (type == 0) {
                single();
            }
            else if (type == 1) {
                married();
            }
            else if (type == 2) {
                marriedSingle();
            }
            else if (type == 3) {
                marriedFamily();
            }
        } else {
            System.out.println("Please input a valid number!");
        }
    }
    public void single() {
        for (int i = 0;i <= 4;i++) {
            if(brackets[0][i] <= income && income <= brackets[0][i+1]) {
                System.out.println("Tax is "+(double)income * rates[i+1]);
                break;
            } else if(income <= brackets[0][i]) {
                System.out.println("Tax is"+(double)income * rates[i]);
                break;
            }
        }

    }
    public void married() {
        for (int i = 0;i <= 4;i++) {
            if(brackets[1][i] <= income && income <= brackets[1][i+1]) {
                System.out.println("Tax is "+(double)income * rates[i+1]);
                break;
            } else if(income <= brackets[1][i]) {
                System.out.println("Tax is"+(double)income * rates[i]);
                break;
            }
        }
    }
    public void marriedSingle() {
        for (int i = 0;i <= 4;i++) {
            if(brackets[2][i] <= income && income <= brackets[2][i+1]) {
                System.out.println("Tax is "+(double)income * rates[i+1]);
                break;
            } else if(income <= brackets[2][i]) {
                System.out.println("Tax is"+(double)income * rates[i]);
                break;
            }
        }
    }
    public void marriedFamily() {
        for (int i = 0;i <= 4;i++) {
            if(brackets[3][i] <= income && income <= brackets[3][i+1]) {
                System.out.println("Tax is "+(double)income * rates[i+1]);
                break;
            } else if(income <= brackets[3][i]) {
                System.out.println("Tax is"+(double)income * rates[i]);
                break;
            }
        }
    }

    public static void main(String[] agrs) {
        TaxList newOne = new TaxList();
        newOne.showType();
        newOne.getType();
        newOne.getIncome();
        newOne.tax();
    }
}
