package oscarblancarte.ipd.proxy;

import oscarblancarte.ipd.proxy.impl.IProcessEjecutor;
import oscarblancarte.ipd.proxy.impl.ServiceFactory;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ProxyMain {

    public static void main(String[] args) {
        String user = "oblancarte";
        String password = "1234";
        int process = 1;
        IProcessEjecutor processEjecutor = ServiceFactory.createProcessEjecutor();
        try {
            processEjecutor.ejecuteProcess(process, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}