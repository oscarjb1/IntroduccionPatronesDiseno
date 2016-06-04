package oscarblancarte.ipd.abstractfactory.ws;

import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class EmployeeServiceWSImpl implements IEmployeeService {

    private static final String[] EMPLOYEES = new String[]{"Maria", "Rebeca", "Liliana"};

    @Override
    public String[] getEmployee() {
        System.out.println("WebServices");
        return EMPLOYEES;
    }

}
