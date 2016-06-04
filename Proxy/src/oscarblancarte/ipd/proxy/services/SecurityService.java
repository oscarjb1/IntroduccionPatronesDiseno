package oscarblancarte.ipd.proxy.services;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class SecurityService {
    public boolean authorization(String user,String password){
        if(user.equals("oblancarte") && password.equals("1234")){
            System.out.println("Usuario " + user + " autorizado");
            return true;
        }else{
            System.out.println("Usuario " + user + " NO autorizado");
            return false;
        }
    }
}