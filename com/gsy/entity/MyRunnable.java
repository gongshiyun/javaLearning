package gsy.entity;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 100; i++){
            System.out.println("MyRunnable,序号" + i);
        }
    }
}