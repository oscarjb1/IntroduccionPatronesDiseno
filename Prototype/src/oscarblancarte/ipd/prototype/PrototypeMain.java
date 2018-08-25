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
        
        //We create the initial price list
        //This has the products with the list price
        PriceListImpl standarPriceList = 
                new PriceListImpl("Standar Price List");
        for(int c = 1; c<=5; c++){
            ProductItem item = new ProductItem("Product " + c, c*2);
            standarPriceList.addProductItem(item);
        }
        PrototypeFactory.addPrototype(
                standarPriceList.getListName(), standarPriceList);
        
        //Second list for wholesale customers from the list
        //standard with a 10% discount on the standard price list.
        PriceListImpl wholesalePriceList = (PriceListImpl)
                PrototypeFactory.getPrototype("Standar Price List");
        wholesalePriceList.setListName("Wholesale Price List");
        for(ProductItem item : wholesalePriceList.getProducts()){
            item.setPrice(item.getPrice()*0.90);
        }
        PrototypeFactory.addPrototype(
                wholesalePriceList.getListName(), wholesalePriceList);
        
        //Third price list for VIP customers from the list
        //wholesale with 10% on the wholesale price list.
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