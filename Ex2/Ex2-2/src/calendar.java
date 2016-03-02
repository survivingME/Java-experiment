import java.util.GregorianCalendar;

public class calendar {
    public void showTodayDate () {
        GregorianCalendar aCase = new GregorianCalendar();
        System.out.println(aCase.get(GregorianCalendar.YEAR)+"."+aCase.get(GregorianCalendar.MONTH)/*have a problem*/+"."+aCase.get(GregorianCalendar.DAY_OF_MONTH));
    }
    public void setDate () {
        GregorianCalendar bCase = new GregorianCalendar();
        bCase.setTimeInMillis(1234567898765L);
        System.out.println(bCase.getTime());
    }

    public static void main(String[] agrs) {
        calendar someDay = new calendar();
        someDay.showTodayDate();
        someDay.setDate();

    }
}
