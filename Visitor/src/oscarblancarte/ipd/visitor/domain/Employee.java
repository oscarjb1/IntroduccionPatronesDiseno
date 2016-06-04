package oscarblancarte.ipd.visitor.domain;

import java.util.Objects;
import javax.xml.bind.annotation.*;
import oscarblancarte.ipd.visitor.impl.*;

@XmlRootElement(name = "Responsible")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements IVisitable {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private double price;// for Hour  

    public Employee() {
    }

    public Employee(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.employee(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
