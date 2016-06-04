package oscarblancarte.ipd.facade.util;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class Card {
    private String prefix;
    private String company;
    private String cardType;//{Credit|Debit}

    public Card(String prefix, String company, String cardType) {
        this.prefix = prefix;
        this.company = company;
        this.cardType = cardType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    
}