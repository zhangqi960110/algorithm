package algorithm.sort;

import java.util.Scanner;

/**
 * 冒泡排序，每次比较两个相邻的元素，如果它们的顺序错误就把它们交换过来。
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//输入一个数n，表示接下来有n个数
        int t;
        int[] bubble = new int[100];
        for (int i = 0; i < n; i++)
            bubble[i] = in.nextInt();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {//比较大小并交换
                    t = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = t;
                }
            }
        }
        //输出排序结果
        for (int i = 0; i < n; i++) {
            System.out.print(bubble[i] + " ");
        }
    }
}
