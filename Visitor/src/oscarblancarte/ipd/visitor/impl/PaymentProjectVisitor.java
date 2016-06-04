package oscarblancarte.ipd.visitor.impl;

import java.util.*;
import oscarblancarte.ipd.visitor.domain.*;

public class PaymentProjectVisitor
        implements IVisitor<List<EmployeePay>> {

    private Map<String, Number> employeePayment = new HashMap<>();

    @Override
    public void project(Project project) {
        for (Activitie act : project.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void activitie(Activitie activitie) {
        activitie.getResponsible().accept(this);
        for (Activitie act : activitie.getActivities()) {
            act.accept(this);
        }
    }

    @Override
    public void employee(Employee employee) {
        String resp = employee.getName();
        if (employeePayment.containsKey(resp)) {
            employeePayment.put(resp,
                    employeePayment.get(resp).doubleValue()
                    + employee.getPrice());
        } else {
            employeePayment.put(resp, employee.getPrice());
        }
    }

    @Override
    public List<EmployeePay> getResult() {
        List<EmployeePay> response = new ArrayList<>();

        Set<String> keys = employeePayment.keySet();
        for (String key : keys) {
            response.add(new EmployeePay(key,
                    employeePayment.get(key).doubleValue()));
        }

        return response;
    }

}