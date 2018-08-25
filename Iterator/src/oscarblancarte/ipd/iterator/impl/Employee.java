package oscarblancarte.ipd.iterator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class Employee implements IContainer<Employee> {

    private String name;
    private String role;
    private List<Employee> subordinates;

    public Employee(String role, String puesto, Employee... subordinates) {
        this.name = role;
        this.role = puesto;
        this.subordinates = Arrays.asList(subordinates);
    }

    @Override
    public IIterator<Employee> createIterator() {
        return new TreeEmployeeIterator();
    }

    private class TreeEmployeeIterator implements IIterator<Employee> {

        private LinkedList<Employee> list = new LinkedList<Employee>();
        private int index = 0;

        public TreeEmployeeIterator() {
            addRecursive(Employee.this);
        }

        public void addRecursive(Employee employee) {
            list.add(employee);
            if (employee.getSubordinates() != null) {
                for (Employee subordinate : employee.getSubordinates()) {
                    addRecursive(subordinate);
                }
            }
        }

        @Override
        public boolean hasNext() {
            if (list.isEmpty()) {
                return false;
            }

            return index < list.size();
        }

        @Override
        public Employee next() {
            if (!hasNext()) {
                throw new RuntimeException("there are no more elements");
            }
            return list.get(index++);
        }
    }

    public String getRole() {
        return name;
    }

    public void setRole(String name) {
        this.name = name;
    }

    public String getPuesto() {
        return role;
    }

    public void setPuesto(String puesto) {
        this.role = puesto;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void addSubordinate(Employee subordinate) {
        if (subordinate == null) {
            subordinates = new ArrayList<>();
        }
        subordinates.add(subordinate);
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", role=" + role + '}';
    }
}