package oscarblancarte.ipd.bridge.encript;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class NoEncryptAlgorithm implements IEncryptAlgorithm{
    @Override
    public String encrypt(String message, String password) throws Exception {
        return message;
    }
}