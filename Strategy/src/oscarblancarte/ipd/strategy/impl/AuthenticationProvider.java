package oscarblancarte.ipd.strategy.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class AuthenticationProvider {
    private IAuthenticationStrategy authenticationStrategy;
    
    public void setAuthenticationStrategy(IAuthenticationStrategy strategy){
        this.authenticationStrategy = strategy;
    }
    
    public Principal authenticate(String userName, String password){
        if(authenticationStrategy==null){
            throw new RuntimeException("Strategy not found");
        }
        return authenticationStrategy.authenticate(userName, password);
    }
}