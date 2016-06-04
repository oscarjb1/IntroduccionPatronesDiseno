package oscarblancarte.ipd.adapter.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class BankCreditRequest {
    private String customer;
    private double amount;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}