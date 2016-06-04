package oscarblancarte.ipd.builder.dto;

/**
 *
 * @author oblancarte
 */
public class Address {
    private String address;
    private String city;
    private String country;
    private String cp;

    public Address() {
    }

    public Address(String address, String city, String country, String cp) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.cp = cp;
    }
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Address{" + "address=" + address + ", city=" + city + ", country=" + country + ", cp=" + cp + '}';
    }
}