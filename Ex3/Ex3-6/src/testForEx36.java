/**
 * Created by 15510 on 2016/3/29.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class testForEx36{
    public static void main(String[] agrs) {
        Scanner in=new Scanner(System.in);
        List<Object> list = new ArrayList();
        System.out.println("Input the loan(double):");
        Loan loan = new Loan(in.nextDouble());
        list.add(loan);
        System.out.println("Input the Account(String):");
        Account account = new Account(in.next());
        list.add(account);
        System.out.println("Input the Person(String):");
        Person person = new Person(in.next());
        list.add(person);
        SimpleDateFormat df = new SimpleDateFormat("E MM d HH:mm:ss z yyyy");
        list.add(df);
        System.out.println("Input the calendar(int year, int month, int day):");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(in.nextInt(),in.nextInt(),in.nextInt());
        list.add(gregorianCalendar);
        for(int i = 0;i < list.size();i++) {
            if(i != 3) {
                System.out.println(list.get(i).toString() + "\n");
            } else {
                System.out.println(df.format(new Date())+"\n");
            }
        }


    }
}
