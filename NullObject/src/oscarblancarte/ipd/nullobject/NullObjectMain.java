package oscarblancarte.ipd.nullobject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oscarblancarte.ipd.nullobject.dao.EmployeeDAOService;
import oscarblancarte.ipd.nullobject.domain.Employee;

public class NullObjectMain {
    public static void main(String[] args) {
        EmployeeDAOService service = new EmployeeDAOService();
        Employee emp1 = service.findEmployeeById(1L);
        System.out.println(emp1.getAddress().getFullAddress());

        Employee emp2 = service.findEmployeeById(2L);
        System.out.println(emp2.getAddress().getFullAddress());
    }
}