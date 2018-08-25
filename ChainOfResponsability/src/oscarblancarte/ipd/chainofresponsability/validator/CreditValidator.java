package oscarblancarte.ipd.chainofresponsability.validator;

import oscarblancarte.ipd.chainofresponsability.domain.CreditData;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class CreditValidator extends AbstractOrderValidator{

    @Override
    public void validate(AbstractOrder order)throws ValidationException {
        double total = order.getTotal();
        CreditData creditData = order.getContributor().getCreditData();
        double newBalance = creditData.getBalance() + total;
        if(newBalance > creditData.getCreditLimit()){
            throw new ValidationException("The amount of the order  "
                    + "exceeds the available credit limit");
        }
    }
}