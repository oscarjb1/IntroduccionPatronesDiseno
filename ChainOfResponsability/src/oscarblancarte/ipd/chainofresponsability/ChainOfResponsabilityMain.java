package oscarblancarte.ipd.chainofresponsability;

import java.util.*;
import oscarblancarte.ipd.chainofresponsability.domain.*;
import oscarblancarte.ipd.chainofresponsability.domain.order.*;
import oscarblancarte.ipd.chainofresponsability.validator.*;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ChainOfResponsabilityMain {

    public static void main(String[] args) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDeliveryDate(Calendar.getInstance());
        Customer customer = new Customer();
        customer.setName("Oscar Blancarte");
        customer.setRfc("XXX0000000X0");
        customer.setStatus(Status.ACTIVO);

        Telephone phone = new Telephone();
        phone.setExt("123");
        phone.setLada("999");
        phone.setNumber("1234567");
        customer.setTelephone(phone);

        Address address = new Address();
        address.setAddress1("Address 1");
        address.setAddress2("Address 2");
        address.setCP("1234");
        address.setCountry("Mexico");
        customer.setAddress(address);

        CreditData creditData = new CreditData();
        creditData.setBalance(1000);
        creditData.setCreditLimit(13000);
        customer.setCreditData(creditData);

        salesOrder.setContributor(customer);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (int c = 0; c < 10; c++) {
            OrderItem item = new OrderItem();
            item.setPrice((c + 1) * 30);
            Product product = new Product();
            product.setListPrice((c + 1) * 32);
            product.setName("Product " + (c + 1));
            item.setProduct(product);
            item.setQuantity(0);
            orderItems.add(item);
        }
        salesOrder.setOrderItems(orderItems);
        System.out.println("Total orden > " + salesOrder.getTotal());
        try {
            AbstractOrderValidator validator
                    = OrderValidatorBuilder.buildSalesOrderValidator();
            validator.validate(salesOrder);
            System.out.println("Validación exitosa");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
