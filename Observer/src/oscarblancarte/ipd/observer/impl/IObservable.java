package oscarblancarte.ipd.observer.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IObservable {

    public void addObserver(IObserver observer);

    public void removeObserver(IObserver observer);

    public void notifyAllObservers(String command, Object source);
}