package oscarblancarte.ipd.abstractfactory.impl;

import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;
import oscarblancarte.ipd.abstractfactory.service.IProductsService;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IServiceStackAbstractFactory {
    public IEmployeeService getEmployeeService();
    public IProductsService getProductsService();
}
