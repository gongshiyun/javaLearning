package gsy.main;


import gsy.entity.MyRunnable;
import gsy.entity.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程的三种初始化方式
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 3.FutureTask实现带返回值的线程
 *
 * @author gsyun
 * @date 2018/07/02
 */
public class Main1 {
    public static void main(String[] args){
        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());
        FutureTask<Integer> futureTask = new FutureTask<Integer>(
            (Callable<Integer>)()->{
                return 5;
            }
        );
        Thread thread3 = new Thread(futureTask,"有返回值的线程");

        System.out.println("Thread1启动");
        thread1.start();
        System.out.println("Thread2启动");
        thread2.start();
        System.out.println("Thread3启动");
        thread3.start();

        try{
            System.out.println("Thread3返回值："+futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
