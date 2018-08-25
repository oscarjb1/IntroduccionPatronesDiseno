package oscarblancarte.ipd.facade.impl;

import java.util.HashMap;
import oscarblancarte.ipd.facade.subsystems.bank.BankSystem;
import oscarblancarte.ipd.facade.subsystems.bank.TransferRequest;
import oscarblancarte.ipd.facade.subsystems.biller.BillingPayRequest;
import oscarblancarte.ipd.facade.subsystems.biller.BillingSystem;
import oscarblancarte.ipd.facade.subsystems.crm.CRMSystem;
import oscarblancarte.ipd.facade.subsystems.email.EmailSystem;
import oscarblancarte.ipd.facade.util.Customer;
import oscarblancarte.ipd.facade.util.OnMemoryDataBase;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class OnlinePaymentFacadeImpl implements IPaymentFacade {

    private static final CRMSystem crmSystem = new CRMSystem();
    private static final BillingSystem billingSyste = new BillingSystem();
    private static final BankSystem bankSyste = new BankSystem();
    private static final EmailSystem emailSenderSystem = new EmailSystem();
    
    
    @Override
    public PaymentResponse pay(PaymentRequest request) 
            throws GeneralPaymentError {
        Customer customer = crmSystem.findCustomer(request.getCustomerId());
        //Validate Set
        if(customer==null){
            throw new GeneralPaymentError("Customer ID does not exist '"
                    +request.getCustomerId()+"' not exist.");
        }else if("Inactive".equals(customer.getStatus())){
            throw new GeneralPaymentError("Customer ID does not exist '"
                    +request.getCustomerId()+"' is inactive.");
        }else if(request.getAmmount() > 
                billingSyste.queryCustomerBalance(customer.getId())){
            throw new GeneralPaymentError("You are trying to make a payment "
                    + "\n\tgreater than the customer's balance");
        }
        
        //charge to the card
        TransferRequest transfer = new TransferRequest(
                request.getAmmount(),request.getCardNumber(), 
                request.getCardName(), request.getCardExpDate(), 
                request.getCardNumber());
        String payReference = bankSyste.transfer(transfer);
        
        //Impact of the balance in the billing system
        BillingPayRequest billingRequest = new BillingPayRequest(
                request.getCustomerId(), request.getAmmount());
        double newBalance = billingSyste.pay(billingRequest);
        
        //The client is reactivated if the new balance is less than $ 51
        String newStatus = customer.getStatus();
        if(newBalance<=50){
            OnMemoryDataBase.changeCustomerStatus(request.getCustomerId(), "Active");
            newStatus = "Active";
        }
        
        //Envio de la confirmación de pago por Email.
        HashMap<String,String> params = new HashMap<>();
        params.put("$name", customer.getName());
        params.put("$ammount", request.getAmmount()+"");
        params.put("$newBalance", newBalance+"");
        String number = request.getCardNumber();
        String subfix = number.substring(number.length()-4, number.length());
        params.put("$cardNumber", subfix);
        params.put("$reference", payReference);
        params.put("$newStatus", newStatus);
        emailSenderSystem.sendEmail(params);
        
        return new PaymentResponse(payReference, newBalance, newStatus);
        
    }
}