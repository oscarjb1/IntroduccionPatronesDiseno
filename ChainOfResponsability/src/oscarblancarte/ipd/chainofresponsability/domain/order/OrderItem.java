package oscarblancarte.ipd.chainofresponsability.domain.order;

import oscarblancarte.ipd.chainofresponsability.domain.Product;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class OrderItem {

    private Product product;
    private double price;
    private float quantity;

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getTotal(){
        return price*quantity;
    }
}
