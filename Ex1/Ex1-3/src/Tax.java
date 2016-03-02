import java.util.Scanner;

public class Tax {
    int type;
    long income;
    double taxRate, tax;

    public void listType() {
        System.out.print("<0-单身纳税人，1-已婚共同纳税人或证实的孤寡，2-已婚单独纳税人，3-家庭户主纳税人>\n");
    }
    public void getType () {
        System.out.print("\nEnter the filing status:");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        type = Integer.parseInt(input);
        //return type;
    }
    public void getIncome() {
        System.out.print("Enter the taxable income:");
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        income = Integer.parseInt(input);
    }

    public void getTax() {
        if (0 <= type && type <=3) {
            if (type == 0) {
                single();
            }
            else if( type == 1) {
                married();
            }
            else if (type == 2) {
                marriedSingle();
            }
            else if (type == 3) {
                marriedFamily();
            }
        }
        else {
            System.out.println("Please input valid type number(0<=type<=3)!");
        }



    }
    public void single() {
        if (0 <= income&& income <= 8350) {
            taxRate = 0.1;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (8351 <= income && income <= 33950) {
            taxRate = 0.15;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (33951 <= income && income <= 82250) {
            taxRate = 0.25;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (82251 <= income && income <= 171550) {
            taxRate = 0.28;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (171551 <= income && income <= 372950) {
            taxRate = 0.33;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (income >= 372951) {
            taxRate = 0.35;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }

    }

    public void married() {
        if (0 <= income && income <= 16700) {
            taxRate = 0.1;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (16701 <= income && income <= 67900) {
            taxRate = 0.15;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (67901 <= income && income <= 137050) {
            taxRate = 0.25;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (137051 <= income && income <=208850) {
            taxRate = 0.28;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (208851 <= income && income <=372950) {
            taxRate = 0.33;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (income >= 372951) {
            taxRate = 0.35;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
    }

    public void marriedSingle() {
        if (0 <= income&& income <= 8350) {
            taxRate = 0.1;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (8351 <= income && income <= 33950) {
            taxRate = 0.15;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (33951 <= income && income <= 68525) {
            taxRate = 0.25;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (68526 <= income && income <= 104425) {
            taxRate = 0.28;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (104426 <= income && income <= 186475) {
            taxRate = 0.33;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (income >= 186476) {
            taxRate = 0.35;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }

    }

    public void marriedFamily() {
        if (0 <= income && income <= 11850) {
            taxRate = 0.1;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (11951 <= income && income <= 45500) {
            taxRate = 0.15;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (45501 <= income && income <= 117450) {
            taxRate = 0.25;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (117451 <= income && income <=190200) {
            taxRate = 0.28;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (190201 <= income && income <=372950) {
            taxRate = 0.33;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
        else if (income >= 372951) {
            taxRate = 0.35;
            tax = taxRate *(double)income;
            System.out.println("Tax is "+tax);
        }
    }

    public static void main(String[] agrs) {
        Tax newOne = new Tax();
        newOne.listType();
        newOne.getType();
        newOne.getIncome();
        newOne.getTax();

    }

}



