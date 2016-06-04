package oscarblancarte.ipd.chainofresponsability.domain;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public abstract class Contributor {

    private String name;
    private String rfc;
    private Status status;
    
    private Address address;
    private Telephone telephone;
    private CreditData creditData;

    public CreditData getCreditData() {
        return creditData;
    }

    public void setCreditData(CreditData creditData) {
        this.creditData = creditData;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

}
