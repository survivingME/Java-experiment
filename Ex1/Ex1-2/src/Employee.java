import java.util.Scanner;
import java.math.BigDecimal;
/**
 * Created by Tremble on 2016/3/2.
 */
public class Employee {

    int hour;
    double salary, sum, federalTax, stateTax;
    String name;


    public void getName() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Enter employee's name:");
        input = scanner.next();
        name = input;
    }

    public void getWorkHour() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Enter number of hour worked in a week:");
        input = scanner.next();
        hour = Integer.parseInt(input);
    }

    public void getSalary() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Enter hourly pay rate: ");
        input = scanner.next();
        salary = Double.parseDouble(input);
    }

    public void getFederalTax() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Enter federal tax withholding rate:");
        input = scanner.next();
        federalTax = Double.parseDouble(input);

    }

    public void getStateRate() {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Enter state tax withholding rate:");
        input = scanner.next();
        stateTax = Double.parseDouble(input);
    }

    public void getsum () {
        sum = salary * (float)hour;
    }

    public void getInfo() {
        double FederalTaxed = sum * federalTax;
        BigDecimal FTD = new BigDecimal(Double.parseDouble(String.valueOf(FederalTaxed)));
        double StateTaxed = sum * stateTax;
        BigDecimal STD = new BigDecimal(Double.parseDouble(String.valueOf(StateTaxed)));
        double Taxed = sum * (federalTax + stateTax);
        BigDecimal TD = new BigDecimal(Double.parseDouble(String.valueOf(Taxed)));
        double sumTaxed = sum * (1- federalTax- stateTax);
        BigDecimal sTD = new BigDecimal(Double.parseDouble(String.valueOf(sumTaxed)));
        System.out.println("雇员姓名："+name);
        System.out.println("工作小时数："+hour);
        System.out.println("每小时工资数：$"+salary);
        System.out.println("工资总收入：$"+sum);
        System.out.println("所纳税款:\n    联邦税<"+federalTax * 100+"%>: $"+FTD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n     州税<"+stateTax * 100+"%>: $"+STD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n   总纳税: $"+TD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n净收入: $"+sTD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    public static void  main(String[] agrs) {
        Employee NewEmployee = new Employee();
        NewEmployee.getName();
        NewEmployee.getWorkHour();
        NewEmployee.getSalary();
        NewEmployee.getFederalTax();
        NewEmployee.getStateRate();
        NewEmployee.getsum();
        NewEmployee.getInfo();
    }


}
