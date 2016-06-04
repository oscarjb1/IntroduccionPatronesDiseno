package oscarblancarte.ipd.abstractfactory.ws;

import oscarblancarte.ipd.abstractfactory.service.IProductsService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ProductServiceWSImpl implements IProductsService {

    private static final String[] PRODUCTS = new String[]{"Refresco", "Jugo", "Fruta"};

    @Override
    public String[] getProducts() {
        System.out.println("WebServices");
        return PRODUCTS;
    }
}