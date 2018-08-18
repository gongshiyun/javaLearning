package gsy.entity.sortMethods;

import java.util.Arrays;

/**
 * @author gongshiyun
 * @Description 冒泡排序
 * @date 2018/8/13
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 4, 5, 3, 9, 0};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }


}
