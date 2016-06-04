package oscarblancarte.ipd.bridge;

import oscarblancarte.ipd.bridge.encript.AESEncryptAlgorithm;
import oscarblancarte.ipd.bridge.encript.DESEncryptAlgorithm;
import oscarblancarte.ipd.bridge.encript.NoEncryptAlgorithm;
import oscarblancarte.ipd.bridge.impl.DefaultMessageEncryptImpl;
import oscarblancarte.ipd.bridge.impl.IMessageEncrypt;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class BridgeMain {

    public static void main(String[] args) {
        IMessageEncrypt aesImpl = new DefaultMessageEncryptImpl(
                new AESEncryptAlgorithm());
        IMessageEncrypt desImpl = new DefaultMessageEncryptImpl(
                new DESEncryptAlgorithm());
        IMessageEncrypt noImpl = new DefaultMessageEncryptImpl(
                new NoEncryptAlgorithm());
        
        try {
            final String message = "<Persona><Nombre>Oscar Blancarte</Nombre></Persona>";
            String messageAES = aesImpl.encryptMessage(message, "HG58YZ3CR9123456");
            System.out.println("messageAES > " + messageAES + "\n");
            
            String messageDES = desImpl.encryptMessage(message, "XMzDdG4D03CKm2Ix");
            System.out.println("messageDES > " + messageDES + "\n");
            
            String messageNO = noImpl.encryptMessage(message, null);
            System.out.println("messageNO > " + messageNO + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}