package oscarblancarte.ipd.visitor.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import oscarblancarte.ipd.visitor.impl.IVisitable;
import oscarblancarte.ipd.visitor.impl.IVisitor;

@XmlRootElement(name = "Activitie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Activitie implements IVisitable {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private double price;
    @XmlElement(name = "responsible")
    private Employee responsible;
    @XmlElement(name = "Activities")
    private List<Activitie> activities;

    public Activitie() {
    }

    public Activitie(String name, double price, Employee responsible) {
        this.name = name;
        this.price = price;
        this.responsible = responsible;
    }

    public List<Activitie> getActivities() {
        if (this.activities == null) {
            this.activities = new ArrayList<>();
        }
        return activities;
    }

    public void setActivities(List<Activitie> activities) {
        this.activities = activities;
    }

    public void addActivitie(Activitie activitie) {
        if (this.activities == null) {
            this.activities = new ArrayList<>();
        }
        this.activities.add(activitie);
    }

    public void removeActivitie(Activitie activitie) {
        if (this.activities == null) {
            this.activities = new ArrayList<>();
        }
        this.activities.remove(activitie);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.activitie(this);
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

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }
}
