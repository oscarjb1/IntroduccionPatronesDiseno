package oscarblancarte.ipd.objectpool.impl.poolable;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IPooledObject {
    public boolean validate();
    public void invalidate();
}