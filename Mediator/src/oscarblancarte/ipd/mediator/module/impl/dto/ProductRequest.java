package oscarblancarte.ipd.mediator.module.impl.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductRequest {
    public List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
