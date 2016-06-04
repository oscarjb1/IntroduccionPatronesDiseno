package oscarblancarte.ipd.objectpool.impl;

import oscarblancarte.ipd.objectpool.impl.poolable.ExecutorTask;
import oscarblancarte.ipd.objectpool.impl.factory.IPoolableObjectFactory;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ExecutorThreadPool extends AbstractObjectPool<ExecutorTask>{

    public ExecutorThreadPool(int minInstances, int maxInstances, int waitTime, 
            IPoolableObjectFactory<ExecutorTask> poolableObjectFactory) {
        super(minInstances, maxInstances, waitTime, poolableObjectFactory);
    }
}
