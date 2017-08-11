package algorithm.sort;

import java.util.Scanner;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] list = new int[num];
        for (int i = 0; i < list.length; i++) {
            list[i] = in.nextInt();
        }
        insert_sort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
    }

    public static void insert_sort(int[] a) {
        int key, i;
        for (int j = 0; j < a.length; j++) {
            key = a[j];
            i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }
}
