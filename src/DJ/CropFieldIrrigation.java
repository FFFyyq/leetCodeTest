package DJ;

public class CropFieldIrrigation {

    public static int maximizeCropProduction(int[][] cropField) {
        int m = cropField.length;
        int n = cropField[0].length;

        // 计算每一行和每一列的原始总产量
        int[] rowSums = new int[m];
        int[] colSums = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += cropField[i][j];
                colSums[j] += cropField[i][j];
            }
        }

        // 找到可以翻倍的行和列
        int maxRowSum = Integer.MIN_VALUE;
        int maxRowIdx = -1;
        int maxColSum = Integer.MIN_VALUE;
        int maxColIdx = -1;
        for (int i = 0; i < m; i++) {
            if (rowSums[i] > maxRowSum) {
                maxRowSum = rowSums[i];
                maxRowIdx = i;
            }
        }
        for (int j = 0; j < n; j++) {
            if (colSums[j] > maxColSum) {
                maxColSum = colSums[j];
                maxColIdx = j;
            }
        }

        System.out.println(maxColIdx);
        System.out.println(maxColSum);
        System.out.println(maxRowIdx);
        System.out.println(maxRowSum);

        // 计算灌溉后的总产量
        int totalProduction = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == maxRowIdx || j == maxColIdx) {
                    totalProduction += cropField[i][j] * 2; // 翻倍产量
                } else {
                    totalProduction += cropField[i][j];
                }
            }
        }

        return totalProduction;
    }

    public static void main(String[] args) {
        int[][] cropField = {
                {2, 3, 1, 4},
                {1, 2, 0, 3},
                {4, 2, 1, 7},
                {3, 1 ,4 ,2}
        };

        int maxProduction = maximizeCropProduction(cropField);
        System.out.println("最大化的总产量为: " + maxProduction);
    }
}
