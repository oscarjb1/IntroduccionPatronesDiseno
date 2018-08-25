package oscarblancarte.ipd.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        //Modul 1
        ConfigurationSingleton singletonA = ConfigurationSingleton.getInstance();
        //Modul 2
        ConfigurationSingleton singletonB = ConfigurationSingleton.getInstance();
        
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Same reference ==> " + (singletonA == singletonB));
        
        singletonA.setAppName("Singleton Pattern");
        singletonB.setAppVersion("1.0x");
        
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);
        
        singletonA = null;
        singletonB = null;
        
        singletonA = ConfigurationSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);
    }
}