package oscarblancarte.ipd.decorator.impl.decorators;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import oscarblancarte.ipd.decorator.impl.message.IMessage;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class EncryptMessage extends MessageDecorator {

    private String user;
    private String password;

    public EncryptMessage(String user, String password, IMessage message) {
        super(message);
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public IMessage processMessage() {
        this.message = message.processMessage();
        encryptMessage();
        return message;
    }

    private IMessage encryptMessage() {
        try {
            Key key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");

            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(message.getContent().getBytes());
            String encryptedValue = new BASE64Encoder().encode(encVal);
            message.setContent(encryptedValue);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

}