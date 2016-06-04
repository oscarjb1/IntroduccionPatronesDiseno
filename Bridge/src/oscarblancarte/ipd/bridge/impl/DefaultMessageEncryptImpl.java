package oscarblancarte.ipd.bridge.impl;

import oscarblancarte.ipd.bridge.encript.IEncryptAlgorithm;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class DefaultMessageEncryptImpl implements IMessageEncrypt{
    private IEncryptAlgorithm encryptAlgorith;
    
    public DefaultMessageEncryptImpl(IEncryptAlgorithm encryptAlgorith){
        this.encryptAlgorith = encryptAlgorith;
    }
    
    @Override
    public String encryptMessage(String message, String password)throws Exception {
        return encryptAlgorith.encrypt(message, password);
    }
}