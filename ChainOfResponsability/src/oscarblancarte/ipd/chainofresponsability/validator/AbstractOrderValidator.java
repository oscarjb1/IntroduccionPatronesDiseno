package oscarblancarte.ipd.chainofresponsability.validator;

import java.util.ArrayList;
import java.util.List;
import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public abstract class AbstractOrderValidator {
    
    protected List<AbstractOrderValidator> validators = new ArrayList<>();
    
    public abstract void validate(AbstractOrder order) throws ValidationException;
    
    public void addValidator(AbstractOrderValidator validator){
        validators.add(validator);
    }
}
