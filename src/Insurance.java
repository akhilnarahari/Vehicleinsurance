/**
 * Created by narahara on 7/25/2017.
 */
import java.util.*;
public class Insurance {
    private int iid;
    private double amount;
    private String company;

    public Insurance() {
    }

    public Insurance(double amount, String company) {
        this.amount = amount;
        this.company = company;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getIid() {
        return iid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }
}
