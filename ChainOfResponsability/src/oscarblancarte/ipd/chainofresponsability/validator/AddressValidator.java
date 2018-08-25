package oscarblancarte.ipd.chainofresponsability.validator;

import oscarblancarte.ipd.chainofresponsability.domain.Address;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class AddressValidator extends AbstractOrderValidator{

    @Override
    public void validate(AbstractOrder order) throws ValidationException{
        Address address = order.getContributor().getAddress();
        if(address.getAddress1()==null || address.getAddress1().length()==0){
            throw new ValidationException("Address 1 is mandatory");
        }else if(address.getCP()==null || address.getCP().length()!=4){
            throw new ValidationException("ZIP code must be 4 digits");
        }else if(address.getCountry()==null || address.getCountry().length()==0){
            throw new ValidationException("The country is mandatory");
        }
    }
}