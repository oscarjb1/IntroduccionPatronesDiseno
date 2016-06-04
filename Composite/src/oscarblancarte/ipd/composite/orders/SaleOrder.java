package oscarblancarte.ipd.composite.orders;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import oscarblancarte.ipd.composite.products.AbstractProduct;

/**
 * @author oblancarte
 */
public class SaleOrder {

    private long orderId;
    private String customer;
    private List<AbstractProduct> products = new ArrayList<AbstractProduct>();

    public SaleOrder(long orderId, String customer) {
        super();
        this.orderId = orderId;
        this.customer = customer;
    }
    
    public double getPrice() {
        double price = 0d;
        for (AbstractProduct child : products) {
            price += child.getPrice();
        }
        return price;
    }

    public void addProduct(AbstractProduct product) {
        products.add(product);
    }

    public void printOrder() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n============================================="
                + "\nOrden: " + orderId + "\nCliente: " + customer 
                + "\nProductos:\n");
        for (AbstractProduct prod : products) {
            System.out.println(prod.getName() + "\t\t\t$ " 
                    + formater.format(prod.getPrice()));
        }
        System.out.println("Total: " + formater.format(getPrice()) 
                + "\n=============================================");
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<AbstractProduct> getProducts() {
        return products;
    }

    public void setProducts(List<AbstractProduct> products) {
        this.products = products;
    }
}