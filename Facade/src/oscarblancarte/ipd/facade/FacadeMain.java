package oscarblancarte.ipd.facade;

import oscarblancarte.ipd.facade.impl.IPaymentFacade;
import oscarblancarte.ipd.facade.impl.OnlinePaymentFacadeImpl;
import oscarblancarte.ipd.facade.impl.PaymentRequest;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class FacadeMain {

    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest();
        request.setAmmount(500);
        request.setCardExpDate("10/2015");
        request.setCardName("Oscar Blancarte");
        request.setCardNumber("1234567890123456");
        request.setCardSecureNum("345");
        request.setCustomerId(1L);

        try {
            IPaymentFacade paymentFacade = new OnlinePaymentFacadeImpl();
            paymentFacade.pay(request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}