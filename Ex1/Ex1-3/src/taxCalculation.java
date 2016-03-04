import java.util.Scanner;

public class taxCalculation {
    public static void main(String[] agrs) {
        int type;
        long income;
        String input;
        double taxRate = 0.1, taxRate1 = 0.15, taxRate2 = 0.25, taxRate3 = 0.28, taxRate4 = 0.33, taxRate5 = 0.35, tax = 0;
        Scanner scanner = new Scanner(System.in);

        //列出种类
        System.out.println("<0-单身纳税人，1-已婚共同纳税人或证实的孤寡，2-已婚单独纳税人，3-家庭户主纳税人>");

        //读取种类
        System.out.print("\nEnter the filing status:");
        input = scanner.next();
        type = Integer.parseInt(input);

        //读取收入
        System.out.print("Enter the taxable income:");
        input = scanner.next();
        income = Integer.parseInt(input);

        //计算税款
        if (0 <= type && type <=3) {
            if (type == 0) {
                if (0 <= income&& income <= 8350) {
                    tax = taxRate * income;

                }
                else if (income <= 33950) {
                    tax = taxRate1 *(income - 8350) + taxRate *8350 ;

                }
                else if (income <= 82250) {
                    tax = taxRate2 *(income - 33950) + taxRate * 8350 + taxRate1 * (33950 - 8350);

                }
                else if (income <= 171550) {
                    tax = taxRate3 *(income - 82250) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (82250 - 33590);

                }
                else if (income <= 372950) {
                    tax = taxRate4 *(income - 171550) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (82250 - 33950) + taxRate3 * (171550 - 82250);

                }
                else if (income > 372950) {
                    tax = taxRate5 *(income - 372950) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (82250 - 33950) + taxRate3 * (171550 - 82250) + taxRate4 * (372950 - 171550);

                }
            }
            else if( type == 1) {
                if (0 <= income&& income <= 16700) {
                    tax = taxRate * income;

                }
                else if (income <= 67900) {
                    tax = taxRate1 * (income - 16700) + taxRate *16700 ;

                }
                else if (income <= 137050) {
                    tax = taxRate2 * (income - 67900) + taxRate * 16700 + taxRate1 * (67900 - 16700);

                }
                else if (income <= 208850) {
                    tax = taxRate3 * (income - 137050) + taxRate * 16700 + taxRate1 * (67900 - 16700) + taxRate2 * (137050 - 67900);

                }
                else if (income <= 372950) {
                    tax = taxRate4 * (income - 208850) + taxRate * 16700 + taxRate1 * (67900 - 16700) + taxRate2 * (137050 - 67900) + taxRate3 * (208850 - 137050);

                }
                else if (income > 372950) {
                    tax = taxRate5 * (income - 372950) + taxRate * 16700 + taxRate1 * (67900 - 16700) + taxRate2 * (137050 - 67900) + taxRate3 * (208850 - 137050) + taxRate4 * (372950 - 208850);

                }
            }
            else if (type == 2) {
                if (0 <= income&& income <= 8350) {
                    tax = taxRate * income;

                }
                else if (income <= 33950) {
                    tax = taxRate1 * (income - 8350) + taxRate *8350 ;

                }
                else if (income <= 68525) {
                    tax = taxRate2 * (income - 33950) + taxRate * 8350 + taxRate1 * (33950 - 8350);

                }
                else if (income <= 104425) {
                    tax = taxRate3 * (income - 68525) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (68525 - 33590);

                }
                else if (income <= 186475) {
                    tax = taxRate4 * (income - 104425) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (68525 - 33590) + taxRate3 * (104425 - 68525);

                }
                else if (income > 186475) {
                    tax = taxRate5 * (income - 186475) + taxRate * 8350 + taxRate1 * (33950 - 8350) + taxRate2 * (68525 - 33590) + taxRate3 * (104425 - 68525) + taxRate4 * (186476 - 104425);

                }
            }
            else if (type == 3) {
                if (0 <= income&& income <= 11950) {
                    tax = taxRate * income;

                }
                else if (income <= 45500) {
                    tax = taxRate1 * (income - 11950) + taxRate *11950 ;

                }
                else if (income <= 117450) {
                    tax = taxRate2 * (income - 45500) + taxRate * 11950 + taxRate1 * (45500 - 11950);

                }
                else if (income <= 190200) {
                    tax = taxRate3 * (income - 117450) + taxRate * 11950 + taxRate1 * (45500 - 11950) + taxRate2 * (117450 - 45500);

                }
                else if (income <= 372950) {
                    tax = taxRate4 * (income - 190200) + taxRate * 11950 + taxRate1 * (45500 - 11950) + taxRate2 * (117450 - 45500) + taxRate3 * (190200 - 117450);

                }
                else if (income > 372950) {
                    tax = taxRate5 * (income - 372950) + taxRate * 11950 + taxRate1 * (45500 - 11950) + taxRate2 * (117450 - 45500) + taxRate3 * (190200 - 117450) + taxRate4 * (372950 - 190200);

                }
            }
            System.out.println("Tax is "+tax);
        }
        else {
            System.out.println("Please input valid type number(0<=type<=3)!");
        }
    }
}
