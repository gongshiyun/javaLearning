package gsy.entity.sortMethods;

/**
 * @author gongshiyun
 * @Description 排序抽象类
 * @date 2018/8/9
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换
     * @param a
     * @param i
     * @param j
     */
    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
