package oscarblancarte.ipd.chainofresponsability.validator;

import oscarblancarte.ipd.chainofresponsability.domain.order.AbstractOrder;
import oscarblancarte.ipd.chainofresponsability.domain.order.SalesOrder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SalesOrderValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        if (!(order instanceof SalesOrder)) {
            throw new ValidationException("Se esperaba una orden de Venta");
        }

        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
    }
}
