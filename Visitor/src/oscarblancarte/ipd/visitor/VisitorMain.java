package oscarblancarte.ipd.visitor;

import java.util.List;
import javax.xml.bind.*;
import oscarblancarte.ipd.visitor.domain.*;
import oscarblancarte.ipd.visitor.impl.*;

public class VisitorMain {

    public static void main(String[] args) {

        Project project = null;
        try {
            JAXBContext context
                    = JAXBContext.newInstance(Project.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            project = (Project) unmarshaller
                    .unmarshal(VisitorMain.class
                            .getResourceAsStream("/META-INF/Project.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //Obtener el costo total del proyecto  
        CostProjectVisitor costVisitor = new CostProjectVisitor();
        project.accept(costVisitor);
        double cost = costVisitor.getResult().doubleValue();
        System.out.println("Costo total > " + cost);

        //Obtener el precio de venta del proyecto  
        PriceProjectVisitor priceVisitor = new PriceProjectVisitor();
        project.accept(priceVisitor);
        double price = priceVisitor.getResult().doubleValue();
        System.out.println("Precio total > " + price);
        System.out.println("Ganancia Total > " + (price - cost));

        //Mistrar el total a pagar por empleado  
        System.out.println("\n:::::::: Pagar a los trabajadores :::::::");
        PaymentProjectVisitor paymentVisitor
                = new PaymentProjectVisitor();
        project.accept(paymentVisitor);
        List<EmployeePay> result = paymentVisitor.getResult();
        for (EmployeePay pay : result) {
            System.out.println(pay.getEmployeeName()
                    + " > " + pay.getTotalPay());
        }
    }
}
