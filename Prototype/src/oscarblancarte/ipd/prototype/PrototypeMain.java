package oscarblancarte.ipd.prototype;

import oscarblancarte.ipd.prototype.impl.PriceListImpl;
import oscarblancarte.ipd.prototype.impl.ProductItem;
import oscarblancarte.ipd.prototype.impl.PrototypeFactory;

/**
 * @author oscar javier blancarte iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class PrototypeMain {

    public static void main(String[] args) {
        
        //Creamos la lista de precios inicial, esta tiene los productos con
        //el precio de lista.
        PriceListImpl standarPriceList = 
                new PriceListImpl("Standar Price List");
        for(int c = 1; c<=5; c++){
            ProductItem item = new ProductItem("Product " + c, c*2);
            standarPriceList.addProductItem(item);
        }
        PrototypeFactory.addPrototype(
                standarPriceList.getListName(), standarPriceList);
        
        //Segunda lista para clientes de mayoreo a partir de la lista
        //standar con un 10% de descuento sobre la lista de precio standar
        PriceListImpl wholesalePriceList = (PriceListImpl)
                PrototypeFactory.getPrototype("Standar Price List");
        wholesalePriceList.setListName("Wholesale Price List");
        for(ProductItem item : wholesalePriceList.getProducts()){
            item.setPrice(item.getPrice()*0.90);
        }
        PrototypeFactory.addPrototype(
                wholesalePriceList.getListName(), wholesalePriceList);
        
        //Tercera lista de precios para clientes VIP a partir de la lista
        //de mayoreo con 10% sobre la lista de precios de mayoreo.
        PriceListImpl vipPriceList = (PriceListImpl)
                PrototypeFactory.getPrototype("Wholesale Price List");
        vipPriceList.setListName("VIP Price List");
        for(ProductItem item : vipPriceList.getProducts()){
            item.setPrice(item.getPrice()*0.90);
        }
        
        //Imprimimos las listas de precio.
        System.out.println(standarPriceList);
        System.out.println(wholesalePriceList);
        System.out.println(vipPriceList);
    }
}