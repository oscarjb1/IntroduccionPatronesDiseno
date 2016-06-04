package oscarblancarte.ipd.abstractfactory.ws;

import oscarblancarte.ipd.abstractfactory.impl.IServiceStackAbstractFactory;
import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;
import oscarblancarte.ipd.abstractfactory.service.IProductsService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class WSServiceStackImpl implements IServiceStackAbstractFactory{

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceWSImpl();
    }

    @Override
    public IProductsService getProductsService() {
        return new ProductServiceWSImpl();
    }
}