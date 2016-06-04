package oscarblancarte.ipd.visitor.impl;

import oscarblancarte.ipd.visitor.domain.Activitie;
import oscarblancarte.ipd.visitor.domain.Employee;
import oscarblancarte.ipd.visitor.domain.Project;

public interface IVisitor<T> {
    public void project(Project project);
    public void activitie(Activitie activitie);
    public void employee(Employee employee);
    public T getResult();
}