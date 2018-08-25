package oscarblancarte.ipd.proxy.services;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SecurityService {
    public boolean authorization(String user,String password){
        if(user.equals("oblancarte") && password.equals("1234")){
            System.out.println("User " + user + " authorized");
            return true;
        }else{
            System.out.println("User " + user + " no authorized");
            return false;
        }
    }
}