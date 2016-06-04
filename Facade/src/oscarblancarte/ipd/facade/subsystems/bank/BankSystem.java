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
            throw new GeneralPaymentError("Tarjeta inválida.");
        }
        String cardCompany = OnMemoryDataBase.getCardCompany(cardNumerPrefix);
        if ("AMEX".equals(cardCompany) && request.getCardNumber().length() != 15) {
            throw new GeneralPaymentError("El número de la tarjeta es inválido");
        } else if (("VISA".equals(cardCompany) || "MASTERCARD".equals(cardCompany))
                && request.getCardNumber().length() != 16) {
            throw new GeneralPaymentError("El número de la tarjeta es inválido");
        }
        String number = request.getCardNumber();
        String cardNumerSubfix = number.substring(number.length()-4, number.length());
        System.out.println("Se ha realizado un cargo al cliente '"
                + request.getCardName() + "' \n"
                + "\tpor el monto de '" + request.getAmmount() + "' a la tarjeta "
                + "terminación '"+cardNumerSubfix+"'.\n");
        
        return UUID.randomUUID().toString();
    }
}