package oscarblancarte.ipd.objectpool.impl.factory;

import oscarblancarte.ipd.objectpool.impl.poolable.ExecutorTask;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ExecutorTaskFactory  implements IPoolableObjectFactory<ExecutorTask>{
    public ExecutorTask createNew(){
        return new ExecutorTask();
    }
}