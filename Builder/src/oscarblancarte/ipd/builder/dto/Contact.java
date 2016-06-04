package oscarblancarte.ipd.builder.dto;

/**
 *
 * @author oblancarte
 */
public class Contact {
    private String name;
    private Phone phone;
    private Address address;

    public Contact() {
    }

    public Contact(String name, Phone phone,Address address) {
        this.name = name;
        this.phone = phone;
    }
    
    public Contact(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", phone=" + phone + '}';
    }
}