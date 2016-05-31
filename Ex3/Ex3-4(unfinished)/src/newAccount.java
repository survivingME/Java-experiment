import java.util.ArrayList;

/**
 * Created by 15510 on 2016/3/22.
 */
public class newAccount extends Account {
    public String name;
    private char type;
    private double amount;
    private String description;
    public void newAccount(String name, int id, double balance) {
        this.name = name;
        setId(id);
        setBalance(balance);
    }

    ArrayList Transaction = new ArrayList();
    public void Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        setBalance(balance);
        this.description = description;
    }

    public void withDraw(char type, double amount, int balance, String description) {
        Transaction(type, amount, balance, description);
    }

    public void deposit(char type, double amount, int balance, String description) {
        Transaction(type, amount, balance, description);
    }

}
