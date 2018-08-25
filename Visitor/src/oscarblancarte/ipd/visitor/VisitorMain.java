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
        //Obtain the total cost of the project  
        CostProjectVisitor costVisitor = new CostProjectVisitor();
        project.accept(costVisitor);
        double cost = costVisitor.getResult().doubleValue();
        System.out.println("Total cost > " + cost);

        //Get the sale price of the project  
        PriceProjectVisitor priceVisitor = new PriceProjectVisitor();
        project.accept(priceVisitor);
        double price = priceVisitor.getResult().doubleValue();
        System.out.println("Total price > " + price);
        System.out.println("Total gain > " + (price - cost));

        //Show the total to pay per employee 
        System.out.println("\n:::::::: Pay the workers :::::::");
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
