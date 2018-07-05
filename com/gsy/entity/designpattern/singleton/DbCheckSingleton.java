package gsy.entity.designpattern.singleton;

/**
 * @author gongshiyun
 * @ClassName DbCheckSingleton
 * @Description 双重检查
 * 优点：线程安全；延迟加载；效率较高。
 * @date 2018/7/5
 */
public class DbCheckSingleton {
    private static volatile DbCheckSingleton instance;

    private DbCheckSingleton(){

    }

    public static DbCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DbCheckSingleton.class){
                if (instance == null){
                    instance = new DbCheckSingleton();
                }
            }
        }
        return instance;
    }
}
