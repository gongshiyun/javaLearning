package gsy.entity.designpattern.singleton;

/**
 *
 * @ClassName Singleton
 * @Description 单例模式-饿汉
 *  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * @author gongshiyun
 * @date 2018/07/05
 */
public class HungrySingleton {
    /**
     * 类装载时实例化静态常量
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 私有构造函数
     */
    private HungrySingleton(){

    }

    /**
     * 静态代码块模式
     * 类实例化的过程放在了静态代码块中
     */
    /*static {
        INSTANCE = new HungrySingleton();
    }*/

    public static HungrySingleton getInstance(){
        return INSTANCE;
    }
}
