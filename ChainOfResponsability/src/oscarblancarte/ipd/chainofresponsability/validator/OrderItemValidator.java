package oscarblancarte.ipd.chainofresponsability.validator;

import java.util.List;
import oscarblancarte.ipd.chainofresponsability.domain.Product;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;
import oscarblancarte.ipd.chainofresponsability.domain.order.OrderItem;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class OrderItemValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem item : orderItems) {
            Product product = item.getProduct();
            if (item.getQuantity() <= 0) {
                throw new ValidationException("El producto '" 
                        + product.getName() + "' no tiene cantidad");
            } 
            
            double listPrice = item.getProduct().getListPrice();
            double price = item.getPrice();
            double priceLimit = listPrice - (listPrice*0.20d);
            if(price < priceLimit){
                throw new ValidationException("El precio del producto '"+
                        product.getName()+"' sobrepasa el límite permitido");
            }
        }
    }
}
