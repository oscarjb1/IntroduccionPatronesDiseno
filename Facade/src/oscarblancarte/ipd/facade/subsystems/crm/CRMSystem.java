package oscarblancarte.ipd.facade.subsystems.crm;

import oscarblancarte.ipd.facade.util.Customer;
import oscarblancarte.ipd.facade.util.OnMemoryDataBase;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class CRMSystem {
    
    public Customer findCustomer(Long customerId){
        return OnMemoryDataBase.findCustomerById(customerId);
    }
}