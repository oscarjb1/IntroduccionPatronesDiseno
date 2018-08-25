package oscarblancarte.ipd.facade.subsystems.email;

import java.util.Map;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class EmailSystem {

    public void sendEmail(Map<String, String> values) {
        String templete = "\n**************************************\n"
                + "|To: $name\n"
                + "|from: FacadeSystem\n"
                + "|\n"
                + "|Thank you very much for using the online \n"
                + "|service to make your payments.\n"
                + "|\n"
                + "|A moment ago we just received a payment:\n"
                + "|\n"
                + "|Payment amount: $ammount.\n"
                + "|New Balance: $newBalance.\n"
                + "|Termination card: $cardNumber\n"
                + "|Payment reference: $reference\n"
                + "|New status: $newStatus\n"
                + "|\n"
                + "|Thanks for your preference.\n"
                + "|\n"
                + "|This email should not be answered as it has \n"
                + "|been sent by an automatic process"
                + "\n**************************************";
        
        for(String str : values.keySet()){
            templete = templete.replace(str, values.get(str));
        }
        
        System.out.println(templete);
    }
}