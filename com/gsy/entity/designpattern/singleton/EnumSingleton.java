package gsy.entity.designpattern.singleton;

/**
 * @author gongshiyun
 * @ClassName EnumSingleton
 * @Description 枚举实现单例模式
 * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * @date 2018/7/5
 */
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {

    }
}
