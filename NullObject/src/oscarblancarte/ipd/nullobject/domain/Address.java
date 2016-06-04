package oscarblancarte.ipd.nullobject.domain;

public class Address {

    public static final Address NULL_ADDRESS = new Address() {
        public String getFullAddress() {
            return "NOT ADDRESS";
        }
    };

    public String fullAddress;

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Address() {
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
