package oscarblancarte.ipd.observer.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IObserver {
    
    public void notifyObserver(String command, Object source);
}