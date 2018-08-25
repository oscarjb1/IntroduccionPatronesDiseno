package oscarblancarte.ipd.abstractfactory.rest;

import oscarblancarte.ipd.abstractfactory.service.IProductsService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ProductServiceRestImpl implements IProductsService{
    private static final String[] PRODUCTS = new String[]{"keyboard","Mouse","Display"};

    @Override
    public String[] getProducts() {
        System.out.println("RestFul");
        return PRODUCTS;
    }
}