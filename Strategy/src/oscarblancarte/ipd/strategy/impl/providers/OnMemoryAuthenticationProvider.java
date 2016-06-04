package oscarblancarte.ipd.strategy.impl.providers;

import oscarblancarte.ipd.strategy.impl.IAuthenticationStrategy;
import oscarblancarte.ipd.strategy.impl.Principal;
import oscarblancarte.ipd.strategy.util.OnMemoryDataBase;
import oscarblancarte.ipd.strategy.util.User;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class OnMemoryAuthenticationProvider implements IAuthenticationStrategy{

    @Override
    public Principal authenticate(String userName, String passwrd) {
        User user = OnMemoryDataBase.findUserByName(userName);
        if(user!=null && user.getPassword().equals(passwrd)){
            return new Principal(user.getUserName(), user.getRol());
        }
        
        return null;
    }
}