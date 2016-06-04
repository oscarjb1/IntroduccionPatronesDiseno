package oscarblancarte.ipd.objectpool.impl;

import oscarblancarte.ipd.objectpool.impl.poolable.IPooledObject;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public interface IObjectPool<T extends IPooledObject> {
    public T getObject() throws PoolException;
    public void releaceObject(T pooledObject);
}
