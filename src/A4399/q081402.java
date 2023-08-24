package A4399;

import java.util.Scanner;

public class q081402 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 总共有N组数据

        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt(); // 基地数量
            int[] heights = new int[n+1]; // 存储基地的高度

            for (int j = 0; j <= n; j++) {
                heights[j] = scanner.nextInt(); // 输入基地的高度
            }

            int energy = 0; // 初始能量
            int minEnergy = 0; // 最小能量

            for (int j = 0; j < n; j++) {
                energy += heights[j] - heights[j+1]; // 更新能量值

                if (energy < 0) {
                    minEnergy -= energy; // 如果能量值为负数，增加初始能量
                    energy = 0; // 能量值置为0
                }
            }

            System.out.println(minEnergy);
        }

        scanner.close();
    }
}