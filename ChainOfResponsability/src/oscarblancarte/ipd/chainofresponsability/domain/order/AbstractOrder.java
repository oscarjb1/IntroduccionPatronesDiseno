package oscarblancarte.ipd.chainofresponsability.domain.order;

import java.util.Calendar;
import java.util.List;
import oscarblancarte.ipd.chainofresponsability.domain.Contributor;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public abstract class AbstractOrder {
    private Calendar createDate;
    private Contributor contributor;
    private List<OrderItem> orderItems;

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public double getTotal(){
        double total = 0d;
        for (OrderItem abstractOrderItem : orderItems) {
            total+=abstractOrderItem.getTotal();
        }
        return total;
    }
    
}
