package oscarblancarte.ipd.adapter.creditapi.bankx;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class XBankCreditRequest {
    private String customerName;
    private double requestAmount;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(double requestAmount) {
        this.requestAmount = requestAmount;
    }
}