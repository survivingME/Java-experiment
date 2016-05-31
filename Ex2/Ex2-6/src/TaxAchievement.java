/**
 * Created by Tremble on 2016/3/10.
 */
public class TaxAchievement {
    int filingStatus;
    final int SINGLE_FILER = 0;
    final int MARRIED_JOINTLY = 1;
    final int MARRIED_SEPERATELY = 2;
    final int HEAD_OF_HOUSEHOLD = 3;
    int[][] brackets;
    double[] rates;
    double taxableIncome;

    public TaxAchievement() {
        this.brackets = new int[4][4];
        this.rates = new double[4];
    }
    public TaxAchievement(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public int getFilingStatus() {return this.filingStatus;}
    public int[][] getBrackets() {return this.brackets;}
    public double[] getRates() {return this.rates;}
    public double getTaxableIncome() {return this.taxableIncome;}

    public void setFilingStatus(int filingStatus1) {this.filingStatus = filingStatus1;}
    public void setBrackets(int[][] brackets1) {this.brackets = brackets1;}
    public void setRates(double[] rates1) {this.rates = rates1;}
    public void setTaxableIncome(double taxableIncome1) {this.taxableIncome = taxableIncome1;}

    public void judgingInterval() {

    }


    public static void main(String[] agrs) {
        int[][] nowBrackets = {
                {0, 27050, 65550, 136750, 297350},
                {0, 45200, 109250, 166500, 2970350},
                {0, 22600, 54625, 83250, 148675},
                {0, 360250, 93650, 151650, 297350}
        };
        double[] nowRates = {0.15, 0.275, 0.305, 0.355, 0.391};

        TaxAchievement aTaxAchievement = new TaxAchievement();
        aTaxAchievement.setBrackets(nowBrackets);
        aTaxAchievement.setRates(nowRates);
        for(int income = 50000;income < 60000;income += 1000) {

        }

    }



}
