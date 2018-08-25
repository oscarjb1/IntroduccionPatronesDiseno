package oscarblancarte.ipd.proxy.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class DefaultProcessEjecutor implements IProcessEjecutor {

    @Override
    public void ejecuteProcess(int idProcess,String user,String password) throws Exception {
        System.out.println("processes " + idProcess + " in action");
        System.out.println("processes " + idProcess + " finished");
    }
}