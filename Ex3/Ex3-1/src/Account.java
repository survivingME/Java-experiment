/**
 * Created by 15510 on 2016/3/20.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;


    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
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
    public String getDateCreated() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(this.dateCreated);
    }
    public void setDateCreated(Date dateCreated) {this.dateCreated = dateCreated;}
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    public void withDraw(int withDrawing) {
        balance -= withDrawing;
    }
    public void deposit(int depositing) {
        balance += depositing;
    }
}
