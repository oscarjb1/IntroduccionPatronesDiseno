package oscarblancarte.ipd.abstractfactory.rest;

import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class EmployeeServiceRestImpl implements IEmployeeService{
    private static final String[] EMPLOYEES = new String[]{"Juan","Pedro","Manuel"};

    @Override
    public String[] getEmployee() {
        System.out.println("RestFul");
        return EMPLOYEES;
    }
}