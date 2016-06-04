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
                + "|Muchas gracias por utilizar el servicio en \n"
                + "|linea para realizar sus pagos.\n"
                + "|\n"
                + "|Hace un momento acabamos de recibir un pago:\n"
                + "|\n"
                + "|Monto del pago: $ammount.\n"
                + "|Nuevo Saldo: $newBalance.\n"
                + "|Tarjeta terminación: $cardNumber\n"
                + "|Referencia de pago: $reference\n"
                + "|Nuevos status: $newStatus\n"
                + "|\n"
                + "|Gracias por su preferencia.\n"
                + "|\n"
                + "|Este correo no deberá ser contestado ya que \n"
                + "|ha sido enviado por un proceso automático"
                + "\n**************************************";
        
        for(String str : values.keySet()){
            templete = templete.replace(str, values.get(str));
        }
        
        System.out.println(templete);
    }
}