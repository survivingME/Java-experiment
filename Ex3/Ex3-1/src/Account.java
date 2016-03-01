import java.util.Date;

/**
 * Created by 15510 on 2016/3/1.
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
      //设置时间问题未解决！
    Date dateCreated = new Date();


    public void Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated.setTime(10928031984L);
    }

    public void Account (int id, double annualInterestRate) {
        this.id = id;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id1) {
        this.id = id1;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance1) {
        this.balance = balance1;
    }
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate1) {
        this.annualInterestRate = annualInterestRate1;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    public void withDraw(int withDrawing) {
        balance -= withDrawing;
    }
    public void deposit(int depositing) {
        balance += depositing;
    }

    public void main(String[] agrs) {
        Account aAccount = new Account();
        aAccount.Account(1122, 20000);
        aAccount.setAnnualInterestRate(.045);
        aAccount.withDraw(2500);
        aAccount.deposit(3000);
        System.out.print(aAccount.balance+" "+
                aAccount.getMonthlyInterestRate()+" "+
                aAccount.dateCreated);
    }
}
