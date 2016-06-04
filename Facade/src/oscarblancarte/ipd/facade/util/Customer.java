package oscarblancarte.ipd.facade.util;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class Customer {

    private Long id;
    private String name;
    private double balance;
    private String status;

    public Customer() {
    }

    public Customer(Long id, String name, double balance, String status) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", "
                + "\nbalance=" + balance + ", status=" + status + '}';
    }

}
