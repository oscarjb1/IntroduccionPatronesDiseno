package oscarblancarte.ipd.strategy;

import java.util.Scanner;
import oscarblancarte.ipd.strategy.impl.AuthenticationProvider;
import oscarblancarte.ipd.strategy.impl.Principal;
import oscarblancarte.ipd.strategy.impl.providers.OnMemoryAuthenticationProvider;
import oscarblancarte.ipd.strategy.impl.providers.SQLAuthenticationProvider;
import oscarblancarte.ipd.strategy.impl.providers.XMLAuthenticationProvider;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class StrategyMain {

    private static Scanner in = new Scanner(System.in);
    private static AuthenticationProvider authProvider = new AuthenticationProvider();

    public static void main(String[] args) {
        changeAuthetificationStrategy();
        Principal principal = null;
        do {
            System.out.println("\n\nFavor de autenticarse:");
            System.out.println("Usuario:");
            String userName = in.next();
            System.out.println("Pasword:");
            String password = in.next();

            principal = authProvider.authenticate(userName, password);
            if (principal == null) {
                System.out.println("Usuario o password inválido.");
                System.out.println("¿Desea cambiar el metodo de autentificación? (S/N)");

                String op = in.next();
                if (op.equalsIgnoreCase("S")) {
                    changeAuthetificationStrategy();
                }
            }
        } while (principal == null);

        System.out.println("Autentificación exitosa");
        System.out.println(principal);
    }

    private static void changeAuthetificationStrategy() {
        System.out.println("Introdusca el tipo de autentificación a utilizar.");
        System.out.println("1.-OnMemory Authentication");
        System.out.println("2.-SQL Authentication");
        System.out.println("3.-XML Authentication");
        int op = in.nextInt();
        switch (op) {
            case 1:
                authProvider.setAuthenticationStrategy(
                        new OnMemoryAuthenticationProvider());
                System.out.println("OnMemory Authentication Select >");
                break;
            case 2:
                authProvider.setAuthenticationStrategy(
                        new SQLAuthenticationProvider());
                System.out.println("SQL Authentication Select >");
                break;
            case 3:
                authProvider.setAuthenticationStrategy(
                        new XMLAuthenticationProvider());
                System.out.println("XML Authentication Select >");
                break;
            default:
                System.out.println("Opcion inválida");
                System.exit(1);
        }
    }
}
