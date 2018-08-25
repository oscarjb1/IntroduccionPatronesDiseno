package oscarblancarte.ipd.facade.subsystems.biller;

import oscarblancarte.ipd.facade.util.Customer;
import oscarblancarte.ipd.facade.util.OnMemoryDataBase;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class BillingSystem {

    public double queryCustomerBalance(Long customerId) {
        Customer customer = OnMemoryDataBase.findCustomerById(customerId);
        return customer.getBalance();
    }

    public double pay(BillingPayRequest billingPay) {
        Customer customer = OnMemoryDataBase.findCustomerById(billingPay.getCustomerId());
        customer.setBalance(customer.getBalance() - billingPay.getAmount());
        System.out.println("Payment applied to the client '"+customer.getName()+"', "
                + "the new balance is '"+customer.getBalance()+"'");
        return customer.getBalance();//new Balance.
    }
}