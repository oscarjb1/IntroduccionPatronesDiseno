package oscarblancarte.ipd.strategy.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IAuthenticationStrategy {
    
    public Principal authenticate(String userName, String passwrd);
}