package oscarblancarte.ipd.adapter;

import oscarblancarte.ipd.adapter.impl.BankCreditRequest;
import oscarblancarte.ipd.adapter.impl.BankCreditResponse;
import oscarblancarte.ipd.adapter.impl.IBankAdapter;
import oscarblancarte.ipd.adapter.impl.XBankCreditAdapter;
import oscarblancarte.ipd.adapter.impl.YBankCreditAdapter;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class AdapterMain {

    public static void main(String[] args) {
        //Generic request for the two API's
        BankCreditRequest request = new BankCreditRequest();
        request.setCustomer("Oscar Blancarte");
        request.setAmount(1000);

        IBankAdapter xBank = new XBankCreditAdapter();
        BankCreditResponse xresponse = xBank.sendCreditRequest(request);
        System.out.println("xBank approved > " + xresponse.isApproved() + "\n");

        IBankAdapter yBank = new YBankCreditAdapter();
        BankCreditResponse yresponse = yBank.sendCreditRequest(request);
        System.out.println("yBank approved > " + yresponse.isApproved() + "\n");

        if (xresponse.isApproved()) {
            System.out.println("xBank approved your credit, congratulations!!");
        } else if (yresponse.isApproved()) {
            System.out.println("yBank approved your credit, congratulations!!");
        } else {
            System.out.println("Sorry your credit has not been approved");
        }
    }
}