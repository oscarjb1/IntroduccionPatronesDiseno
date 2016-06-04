package oscarblancarte.ipd.abstractfactory;

import java.util.Arrays;
import oscarblancarte.ipd.abstractfactory.impl.IServiceStackAbstractFactory;
import oscarblancarte.ipd.abstractfactory.impl.ServiceStackAbstractFactory;
import oscarblancarte.ipd.abstractfactory.service.IEmployeeService;
import oscarblancarte.ipd.abstractfactory.service.IProductsService;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        IServiceStackAbstractFactory factory = 
                ServiceStackAbstractFactory.createServiceFactory();
        IEmployeeService employeeService = factory.getEmployeeService();
        IProductsService productService = factory.getProductsService();
        
        System.out.println("EmployeeService class > " 
                + employeeService.getClass().getCanonicalName());
        System.out.println("ProductService class  > " 
                + productService.getClass().getCanonicalName());
        
        System.out.println("getEmployee > " 
                + Arrays.toString(employeeService.getEmployee()));
        System.out.println("getProduct  > " 
                + Arrays.toString(productService.getProducts()));
    }
}