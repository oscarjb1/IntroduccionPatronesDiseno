package oscarblancarte.ipd.proxy.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IProcessEjecutor {
    public void ejecuteProcess(int idProcess, String user, String password)
            throws Exception;
}