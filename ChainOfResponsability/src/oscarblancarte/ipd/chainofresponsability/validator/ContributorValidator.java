package oscarblancarte.ipd.chainofresponsability.validator;

import oscarblancarte.ipd.chainofresponsability.domain.Contributor;
import oscarblancarte.ipd.chainofresponsability.domain.Status;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ContributorValidator extends AbstractOrderValidator{
    
    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
        Contributor contributor = order.getContributor();
        if(Status.ACTIVO != contributor.getStatus()){
            throw new ValidationException("The taxpayer is not active");
        }
    }
}
