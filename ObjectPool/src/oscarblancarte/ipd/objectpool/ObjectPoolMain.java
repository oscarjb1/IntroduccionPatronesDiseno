package oscarblancarte.ipd.objectpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import oscarblancarte.ipd.objectpool.impl.poolable.ExecutorTask;
import oscarblancarte.ipd.objectpool.impl.factory.ExecutorTaskFactory;
import oscarblancarte.ipd.objectpool.impl.ExecutorThreadPool;
import oscarblancarte.ipd.objectpool.impl.PoolException;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ObjectPoolMain {

    public static void main(String[] args) {
        final ExecutorThreadPool pool = new ExecutorThreadPool(2, 6, 1000*100, new ExecutorTaskFactory());

        for (int c = 0; c < 10; c++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ExecutorTask task = pool.getObject();
                        task.execute();
                        pool.releaceObject(task);
                    } catch (PoolException e) {
                        System.out.println("Error ==> " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        
        try {
            System.in.read();
            System.out.println(pool);
        } catch (Exception e) {
            System.out.println("Out disponible");
        }

    }
}