package oscarblancarte.ipd.iterator.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IContainer<T> {
    public IIterator<T> createIterator();
}