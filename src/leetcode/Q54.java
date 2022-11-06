package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    // 力扣54题，螺旋矩阵，模拟输出——数组
    public static void main(String[] args) {
        System.out.println(new Q54().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new Q54().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(new Q54().spiralOrder(new int[][]{{1,2},{3,4}}));
        System.out.println(new Q54().spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}}));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) {
            list.add(matrix[0][0]);
            return list;
        } else if (m == 1) {
            for (int i = 0; i < n; i++)
                list.add(matrix[0][i]);
            return list;
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        int loop = (m > n ? n : m) / 2;
        int k = 1;
        int startx = 0;
        int starty = 0;
        while (loop > 0) {
            int x = startx;
            int y = starty;
            for (; y < n - k; y++) {
                list.add(matrix[x][y]);
            }
            for (; x < m - k; x++) {
                list.add(matrix[x][y]);
            }
            for (; y > 0 + k - 1; y--) {
                list.add(matrix[x][y]);
            }
            for (; x > 0 + k - 1; x--) {
                list.add(matrix[x][y]);
            }
            loop--;
            k++;
            startx++;
            starty++;
        }
        int min = m > n ? n : m;
        if (min % 2 != 0) {
            if (m > n) {
                for (int i = startx; i < startx + Math.abs(m - n) + 1; i++) {
                    list.add(matrix[i][starty]);
                }
            }
            else {
                for (int i = starty; i < starty + Math.abs(m - n) + 1; i++) {
                    list.add(matrix[startx][i]);
                }
            }
        }
        return list;
    }
}
