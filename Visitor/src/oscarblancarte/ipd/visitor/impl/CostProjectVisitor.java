package oscarblancarte.ipd.visitor.impl;

import oscarblancarte.ipd.visitor.domain.*;

public class CostProjectVisitor implements IVisitor<Number> {

    private double totalCost;

    @Override
    public void project(Project project) {
        for (Activitie act : project.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void activitie(oscarblancarte.ipd.visitor.domain.Activitie activitie) {
        activitie.getResponsible().accept(this);
        for (Activitie act : activitie.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void employee(Employee employee) {
        totalCost += employee.getPrice();
    }

    @Override
    public Number getResult() {
        return totalCost;
    }
}