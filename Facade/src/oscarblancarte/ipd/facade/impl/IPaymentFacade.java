package oscarblancarte.ipd.facade.impl;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public interface IPaymentFacade {
    public PaymentResponse pay(PaymentRequest paymentRequest)throws GeneralPaymentError;
}