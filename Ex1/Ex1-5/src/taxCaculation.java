import java.util.Scanner;

public class taxCaculation {
    public static void main(String[] agrs) {
        int type;
        long income;
        double tax = 0;
        String input;
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets = {
                {8350, 33950, 82250, 171550, 372950},
                {16700, 67900, 137050, 208850, 372950},
                {8350, 33950, 68525, 104425, 186475},
                {11950, 45500, 117450, 190200, 372950}
        };
        Scanner scanner = new Scanner(System.in);

        System.out.print("<0-单身纳税人，1-已婚共同纳税人或证实的孤寡，2-已婚单独纳税人，3-家庭户主纳税人>");

        System.out.print("\nEnter the filing status:");
        input = scanner.next();
        type = Integer.parseInt(input);
        if (type < 0 && type > 3) {
            System.out.println("Please input valid number!");
            System.exit(0);
        }

        System.out.print("Enter the taxable income:");
        input = scanner.next();
        income = Integer.parseInt(input);
        if (income < 0) {
            System.out.println("Please input valid income!");
            System.exit(0);
        }

        if (type < 0) {
            System.out.println("Please input a valid number!");
        } else {
            if(0 <= income && income <= brackets[type][0]) {
                tax = income * rates[0];
            } else if(income <= brackets[type][1]) {
                tax = (income - brackets[type][0]) * rates[1] + brackets[type][0] * rates[0];
            } else if(income <= brackets[type][2]) {
                tax = (income - brackets[type][1]) * rates[2] + (brackets[type][1] - brackets[type][0]) * rates[1] + brackets[type][0] * rates[0];
            } else if(income <= brackets[type][3]) {
                tax = (income - brackets[type][2]) * rates[3] + (brackets[type][2] - brackets[type][1]) * rates[2] + (brackets[type][1] - brackets[type][0]) * rates[1] + brackets[type][0] * rates[0];
            } else if(income <= brackets[type][4]) {
                tax = (income - brackets[type][3]) * rates[4] + (brackets[type][3] - brackets[type][2]) * rates[3] +(brackets[type][2] - brackets[type][1]) * rates[2] + (brackets[type][1] - brackets[type][0]) * rates[1] + brackets[type][0] * rates[0];
            } else if(income > brackets[type][4]) {
                tax = (income - brackets[type][4]) * rates[5] + (brackets[type][4] - brackets[type][3]) * rates[4] + (brackets[type][3] - brackets[type][2]) * rates[3] +(brackets[type][2] - brackets[type][1]) * rates[2] + (brackets[type][1] - brackets[type][0]) * rates[1] + brackets[type][0] * rates[0];
            }
        }
        System.out.println("Tax is "+tax);
    }
}
