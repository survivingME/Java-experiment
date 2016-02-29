import java.util.GregorianCalendar;
/**
 * Created by Tremble on 2016/2/28.
 */
public class Calendar {

    public void showTodayDate () {
        GregorianCalendar aCase = new GregorianCalendar();
        System.out.println(aCase.get(GregorianCalendar.YEAR)+"."+aCase.get(GregorianCalendar.MONTH)+"."+aCase.get(GregorianCalendar.DAY_OF_MONTH));
    }
    public void setDate () {
        GregorianCalendar bCase = new GregorianCalendar();
        bCase.setTimeInMillis(1234567898765L);
        System.out.println(bCase.getTime());
    }

    public static void main(String[] agrs) {
       Calendar someDay = new Calendar();
        someDay.showTodayDate();
        someDay.setDate();

    }

}
