package oscarblancarte.ipd.memento.entity;

import oscarblancarte.ipd.memento.impl.EmployeeMemento;

public class Employee implements Cloneable{
    private String name;
    private String lastName;
    private String employeeNumber;

    public Employee(String name, String lastName, String employeeNumber) {
        this.name = name;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
    }

    public Employee() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    
    public EmployeeMemento createMemento(){
        try {
            return new EmployeeMemento((Employee)this.clone());
        } catch (Exception e) {
            throw new RuntimeException("Error al clonar el empleado");
        }
    }
    
    public void restoreMemento(EmployeeMemento memento){
        Employee employee = memento.getMemento();
        this.name = employee.name;
        this.lastName = employee.name;
        this.employeeNumber = employee.employeeNumber;
    }
}
