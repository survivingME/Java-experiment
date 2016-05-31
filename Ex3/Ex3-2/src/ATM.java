
public class ATM {
    public static void main(String[] agrs) {
        Account aAccount = new Account();
        aAccount.Account(1122, 20000);
        aAccount.setAnnualInterestRate(.045);
        aAccount.withDraw(2500);
        aAccount.deposit(3000);
        //aAccount.setDateCreated();
        System.out.print(aAccount.getBalance()+" "+
                aAccount.getMonthlyInterestRate()+" "+
                aAccount.getDateCreated());
    }
}
