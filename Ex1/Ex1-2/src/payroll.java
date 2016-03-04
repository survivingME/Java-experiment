import java.math.BigDecimal;
import java.util.Scanner;

public class payroll {
    public static void main(String[] agrs) {
        //变量声明
        int hour;
        String input;
        String name;
        double hourlyPay, sum, federalTax, stateTax;

        //Scanner实例声明
        Scanner scanner = new Scanner(System.in);

        //使用方法获取变量
        System.out.println("Enter employee's name:");
        input = scanner.next();
        name = input;

        System.out.println("Enter number of hour worked in a week:");
        input = scanner.next();
        hour = Integer.parseInt(input);

        System.out.println("Enter hourly pay rate:");
        input = scanner.next();
        hourlyPay = Double.parseDouble(input);

        System.out.println("Enter federal tax withholding rate:");
        input = scanner.next();
        federalTax = Double.parseDouble(input);

        System.out.println("Enter state tax withholding rate:");
        input = scanner.next();
        stateTax = Double.parseDouble(input);

        //计算总薪
        sum = hourlyPay * (float)hour;

        //输出
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
        System.out.println("每小时工资数：$"+hourlyPay);
        System.out.println("工资总收入：$"+sum);
        System.out.println("所纳税款:\n    联邦税<"+federalTax * 100+"%>: $"+FTD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n     州税<"+stateTax * 100+"%>: $"+STD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n   总纳税: $"+TD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+
                "\n净收入: $"+sTD.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
