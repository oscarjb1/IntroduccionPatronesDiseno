package oscarblancarte.ipd.proxy.services;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class AuditService {
    public void auditServiceUsed(String user, String service){
        SimpleDateFormat formater= new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        System.out.println(user + " utilizo el servicio > " 
                + service + ", a las " +formater.format(new Date()));
    }
}