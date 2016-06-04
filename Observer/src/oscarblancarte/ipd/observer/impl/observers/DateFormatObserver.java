package oscarblancarte.ipd.observer.impl.observers;

import java.util.Date;
import oscarblancarte.ipd.observer.impl.ConfigurationManager;
import oscarblancarte.ipd.observer.impl.IObserver;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class DateFormatObserver implements IObserver{

    @Override
    public void notifyObserver(String command, Object source) {
        if(command.equals("defaultDateFormat")){
            ConfigurationManager conf = (ConfigurationManager)source;
            System.out.println("Observer ==> DateFormatObserver.dateFormatChange > " 
                    + conf.getDefaultDateFormat().format(new Date()));
        }
    }   
}