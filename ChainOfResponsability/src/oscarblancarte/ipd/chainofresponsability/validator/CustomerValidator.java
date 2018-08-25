package oscarblancarte.ipd.chainofresponsability.validator;

import oscarblancarte.ipd.chainofresponsability.domain.Customer;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class CustomerValidator extends AbstractOrderValidator{
    
    @Override
    public void validate(AbstractOrder order) throws ValidationException{
        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
        
        if(!(order.getContributor() instanceof Customer)){
            throw new ValidationException("The taxpayer is not a client");
        }
    }
}