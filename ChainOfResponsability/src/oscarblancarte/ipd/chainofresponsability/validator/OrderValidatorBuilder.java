package oscarblancarte.ipd.chainofresponsability.validator;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class OrderValidatorBuilder {
    public static final AbstractOrderValidator buildSalesOrderValidator(){
        AbstractOrderValidator validator = new SalesOrderValidator();
        validator.addValidator(buildCustomerValidator());
        validator.addValidator(new OrderItemValidator());
        validator.addValidator(new CreditValidator());
        return validator;
    }
    
    private static AbstractOrderValidator buildCustomerValidator(){
        AbstractOrderValidator validator = new CustomerValidator();
        validator.addValidator(buildContributorValidator());
        return validator;
    }
    
    private static AbstractOrderValidator buildContributorValidator(){
        AbstractOrderValidator validator = new ContributorValidator();
        validator.addValidator(new AddressValidator());
        validator.addValidator(new TelephoneValidator());
        return validator;
    }
}
