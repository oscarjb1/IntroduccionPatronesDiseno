package oscarblancarte.ipd.adapter.impl;

import oscarblancarte.ipd.adapter.creditapi.bankx.XBankCreditAPI;
import oscarblancarte.ipd.adapter.creditapi.bankx.XBankCreditRequest;
import oscarblancarte.ipd.adapter.creditapi.bankx.XBankCreditResponse;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class XBankCreditAdapter implements IBankAdapter{

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());
        
        XBankCreditAPI api = new XBankCreditAPI();
        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);
        
        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(xresponse.isAproval());
        return response;
    }
}