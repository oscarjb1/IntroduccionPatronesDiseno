package oscarblancarte.ipd.memento.impl;

import oscarblancarte.ipd.memento.entity.Employee;

public class EmployeeMemento {
    
    public Employee employee;
    
    public EmployeeMemento(Employee employee){
        this.employee = employee;
    }
    
    public Employee getMemento(){
        return employee;
    }
}