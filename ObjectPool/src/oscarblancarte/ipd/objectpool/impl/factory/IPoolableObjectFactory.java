package oscarblancarte.ipd.objectpool.impl.factory;

import oscarblancarte.ipd.objectpool.impl.poolable.IPooledObject;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IPoolableObjectFactory<T extends IPooledObject> {
    public T createNew();
}