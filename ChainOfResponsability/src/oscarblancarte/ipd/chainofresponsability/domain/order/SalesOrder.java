package oscarblancarte.ipd.chainofresponsability.domain.order;

import java.util.Calendar;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SalesOrder extends AbstractOrder{
    protected Calendar deliveryDate;

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
}
