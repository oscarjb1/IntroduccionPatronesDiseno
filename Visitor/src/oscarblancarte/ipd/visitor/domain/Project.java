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

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements IVisitable{

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "Activities")
    private List<Activitie> activities;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activitie> getActivities() {
        if(this.activities==null){
            this.activities = new ArrayList<>();
        }
        return activities;
    }

    public void setActivities(List<Activitie> activities) {
        this.activities = activities;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.project(this);
    }
}
