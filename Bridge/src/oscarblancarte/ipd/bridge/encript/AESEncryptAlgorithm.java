package oscarblancarte.ipd.bridge.encript;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class AESEncryptAlgorithm implements IEncryptAlgorithm {

    @Override
    public String encrypt(String message, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(), "AES");
        Cipher c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(message.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
}