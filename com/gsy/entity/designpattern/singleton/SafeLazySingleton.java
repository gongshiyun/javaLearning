package gsy.entity.designpattern.singleton;

/**
 * @author gongshiyun
 * @ClassName SafeLazySingleton
 * @Description 单例模式-懒汉(线程安全,同步方法)
 * 缺点：效率低，每个线程获取类的实例都需要进行同步
 * 而其实这个方法只执行一次实例化代码就够了，后面的想
 * 获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 * @date 2018/7/5
 */
public class SafeLazySingleton {
    private static SafeLazySingleton instance;

    private SafeLazySingleton(){

    }

    public static synchronized SafeLazySingleton getInstance(){
        if (instance == null){
            instance = new SafeLazySingleton();
        }
        return instance;
    }
}
