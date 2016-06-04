package oscarblancarte.ipd.bridge.encript;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IEncryptAlgorithm {
    public String encrypt(String message, String password) throws Exception;
}
