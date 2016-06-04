package oscarblancarte.ipd.observer.impl.observers;

import oscarblancarte.ipd.observer.impl.ConfigurationManager;
import oscarblancarte.ipd.observer.impl.IObserver;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class MoneyFormatObserver implements IObserver{
    @Override
    public void notifyObserver(String command, Object source) {
        if(command.equals("moneyFormat")){
            ConfigurationManager conf = (ConfigurationManager)source;
            System.out.println("Observer ==> MoneyFormatObserver.moneyFormatChange > " 
                    + conf.getMoneyFormat().format(1.11));
        }
    }
}