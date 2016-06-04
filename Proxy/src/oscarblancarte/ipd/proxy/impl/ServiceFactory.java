package oscarblancarte.ipd.proxy.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ServiceFactory {
    
    public static IProcessEjecutor createProcessEjecutor(){
        return new ProcessEjecutorProxy();
    }
}