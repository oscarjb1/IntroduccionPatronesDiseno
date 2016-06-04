package oscarblancarte.ipd.mediator.module.impl.dto;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    protected List<Product> productos = new ArrayList<>();

    public List<Product> getProductos() {
        return productos;
    }

    public void addProduct(Product product) {
        this.productos.add(product);
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

}
