package gsy.main;

import gsy.entity.MyTask;

import java.util.concurrent.*;

/**
 * 线程池的使用
 *
 * Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
 *
 * Executors.newSingleThreadExecutor();    //创建容量为1的缓冲池
 *
 * Executors.newFixedThreadPool(int);      //创建固定容量大小的缓冲池
 *
 * workQueue的类型为BlockingQueue<Runnable>，通常可以取下面三种类型：
 *
 * 　　1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
 *
 * 　　2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
 *
 * 　　3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
 * @author gsyun
 * @date 2018/07/02
 */
public class Main2 {
    public static void main(String[] args) {
        //1.使用ThreadPoolExecutor进行初始化
        //ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
        //        new ArrayBlockingQueue<Runnable>(5));

        //2.使用Executors方法获取ThreadPoolExecutor
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池种线程数目" + executor.getPoolSize() +
                    ",队列中等待执行的任务数目：" + executor.getQueue().size() +
                    ",已执行完的任务数目：" + executor.getCompletedTaskCount());
        }

        executor.shutdown();
    }
}
