package oscarblancarte.ipd.bridge.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IMessageEncrypt {
    public String encryptMessage(String message, String password)throws Exception;
}