package algorithm.sort;

import java.util.Scanner;

/**
 * 桶排序,输入n个0~1000之间的整数，将它们从小到大排序
 */
public class BarrelSort_Sim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//输入一个数n，表示接下来有n个数
        int t;
        int[] barrel = new int[1001];
        for (int i = 0; i < n; i++) {
            t = in.nextInt();
            barrel[t]++;
        }
        for (int i = 0; i <= 1000; i++)
            for (int j = 1; j <= barrel[i]; j++)
                System.out.print(i + " ");
    }
}
