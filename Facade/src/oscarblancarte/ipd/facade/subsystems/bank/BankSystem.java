package oscarblancarte.ipd.facade.subsystems.bank;

import java.util.UUID;
import oscarblancarte.ipd.facade.impl.GeneralPaymentError;
import oscarblancarte.ipd.facade.util.OnMemoryDataBase;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class BankSystem {

    public String transfer(TransferRequest request) throws GeneralPaymentError {
        String cardNumerPrefix = request.getCardNumber().substring(0, 3);
        if (!OnMemoryDataBase.validateCardBins(cardNumerPrefix)) {
            throw new GeneralPaymentError("Invalid card.");
        }
        String cardCompany = OnMemoryDataBase.getCardCompany(cardNumerPrefix);
        if ("AMEX".equals(cardCompany) && request.getCardNumber().length() != 15) {
            throw new GeneralPaymentError("Invalid card number");
        } else if (("VISA".equals(cardCompany) || "MASTERCARD".equals(cardCompany))
                && request.getCardNumber().length() != 16) {
            throw new GeneralPaymentError("Invalid card number");
        }
        String number = request.getCardNumber();
        String cardNumerSubfix = number.substring(number.length()-4, number.length());
        System.out.println("A charge has been made to the client '"
                + request.getCardName() + "' \n"
                + "\tFor the amount of '" + request.getAmmount() + "' to the card "
                + "termination '"+cardNumerSubfix+"'.\n");
        
        return UUID.randomUUID().toString();
    }
}