package gsy.entity.sortMethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author gongshiyun
 * @Description 快速排序
 * @date 2018/8/9
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 7, 4, 5, 3, 9, 0};
        System.out.println(Arrays.toString(a));
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a) {
        if (a.length > 0) {
            quickSort(a, 0, a.length - 1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        // 递归出口
        if (low > high) {
            return;
        }
        // 保存遍历前标
        int i = low;
        // 保存遍历后标
        int j = high;
        // 遍历比较的key,取最左一位
        int key = a[low];
        // 完成一趟排序
        while (i < j) {
            // 从右往左找第一个小于key的数
            while (i < j && a[j] > key) {
                --j;
            }
            // 从左往后找第一个大于等于key的数
            while (i < j && a[i] <= key) {
                ++i;
            }
            // 交换
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }

        // key位置交换
        int p = a[i];
        a[i] = a[low];
        a[low] = p;

        // 对key左边的数进行快排
        quickSort(a, low, i - 1);
        // 对key右边的数进行快排
        quickSort(a, i + 1, high);
    }

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int j = partition(nums, left, right);
        sort(nums, left, j - 1);
        sort(nums, j + 1, right);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums, int left, int right) {
        int i = left, j = right;
        T key = nums[left];
        while (true) {
            while (less(key, nums[j]) && (j != i)) {
                j--;
            }
            while (less(nums[i], key) && j != i) {
                i++;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
}
