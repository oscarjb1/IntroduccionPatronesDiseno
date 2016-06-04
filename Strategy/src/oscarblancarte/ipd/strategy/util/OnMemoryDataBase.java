package oscarblancarte.ipd.strategy.util;

import java.util.HashMap;

/**
 * @author Oscar Javier Blancarte Iturralde.
 * @see http://oscarblancarteblog.com
 */
public class OnMemoryDataBase {

    private static final HashMap<String, User> USER_MAP = new HashMap<>();

    static {
        USER_MAP.put("oblancarte",new User("oblancarte", "1234", "Admin"));
        USER_MAP.put("rlopez",new User("rlopez", "2345", "Cajero"));
        USER_MAP.put("lcastro",new User("lcastro", "2345", "Supervisor"));
    }

    public static User findUserByName(String name){
        return USER_MAP.get(name);
    }
}