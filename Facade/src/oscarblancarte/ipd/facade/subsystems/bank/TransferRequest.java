package oscarblancarte.ipd.facade.subsystems.bank;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class TransferRequest {

    private double ammount;
    private String cardNumber;
    private String cardName;
    private String cardExpDate;
    private String cardSecureNum;

    public TransferRequest(double ammount, String cardNumber, String cardName, String cardExpDate, String cardSecureNum) {
        this.ammount = ammount;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardExpDate = cardExpDate;
        this.cardSecureNum = cardSecureNum;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardSecureNum() {
        return cardSecureNum;
    }

    public void setCardSecureNum(String cardSecureNum) {
        this.cardSecureNum = cardSecureNum;
    }

}