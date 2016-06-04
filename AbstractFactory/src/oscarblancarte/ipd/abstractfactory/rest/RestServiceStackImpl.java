package oscarblancarte.ipd.abstractfactory.rest;

import oscarblancarte.ipd.abstractfactory.impl.IServiceStackAbstractFactory;
import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;
import oscarblancarte.ipd.abstractfactory.service.IProductsService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class RestServiceStackImpl implements IServiceStackAbstractFactory{

    @Override
    public IEmployeeService getEmployeeService() {
        return new EmployeeServiceRestImpl();
    }

    @Override
    public IProductsService getProductsService() {
        return new ProductServiceRestImpl();
    }
}