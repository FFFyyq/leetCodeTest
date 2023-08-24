package meituan;

import java.util.*;

public class Forth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        int minWeight = Integer.MAX_VALUE;

        // 遍历所有可能的y值
        for (int y = 1; y <= n; y++) {
            // 检查是否能将字符串平铺成2行y列的矩阵
            if (n % y == 0) {
                int x = n / y;
                char[][] matrix = new char[2][y];

                // 将字符串平铺成矩阵
                for (int i = 0; i < n; i++) {
                    matrix[i / y][i % y] = s.charAt(i);
                }

                // 计算矩阵的权值
                int weight = calculateWeight(matrix);

                // 更新最小权值
                minWeight = Math.min(minWeight, weight);
            }
        }

        System.out.println(minWeight);
    }

    // 计算矩阵的权值
    private static int calculateWeight(char[][] matrix) {
        int weight = 0;
        int[][] visited = new int[2][matrix[0].length];

        // 深度优先搜索
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 0) {
                    weight++;
                    dfs(matrix, visited, i, j);
                }
            }
        }

        return weight;
    }

    // 深度优先搜索
    private static void dfs(char[][] matrix, int[][] visited, int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 2 && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] == matrix[x][y] && visited[nx][ny] == 0) {
                dfs(matrix, visited, nx, ny);
            }
        }
    }
}
