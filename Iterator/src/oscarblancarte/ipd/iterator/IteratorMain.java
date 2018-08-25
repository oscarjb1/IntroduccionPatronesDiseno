package oscarblancarte.ipd.iterator;

import oscarblancarte.ipd.iterator.impl.Employee;
import oscarblancarte.ipd.iterator.impl.IIterator;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class IteratorMain {

    public static void main(String[] args) {
        Employee employee = new Employee("Juan", "CEO",
                new Employee("Pedro", "President",
                        new Employee("Liliana", "VP",
                                new Employee("Oscar", "Manager",
                                        new Employee("Mario", "Developer"),
                                        new Employee("Rodolfo", "Developer")),
                                new Employee("Sofia", "Manager",
                                        new Employee("Adrian", "Sr Developer"),
                                        new Employee("Rebeca", "Developer")
                                )
                        )
                )
        );

        IIterator<Employee> empIterator = employee.createIterator();
        while (empIterator.hasNext()) {
            Employee emp = empIterator.next();
            System.out.println("emp > " + emp.toString());
        }
    }
}