package meituan;

public class CheckAdjacent {
    public static boolean areAdjacent(int[] permutation, int x, int y) {
        int indexOfX = -1;
        int indexOfY = -1;

        for (int i = 0; i < permutation.length; i++) {
            if (permutation[i] == x) {
                indexOfX = i;
            } else if (permutation[i] == y) {
                indexOfY = i;
            }

            if (indexOfX != -1 && indexOfY != -1) {
                break; // Both x and y have been found
            }
        }

        if (Math.abs(indexOfX - indexOfY) == 1) {
            return true; // x and y are adjacent
        } else {
            return false; // x and y are not adjacent
        }
    }

    public static void main(String[] args) {
        int[] permutation = {2, 4, 1, 3, 5};
        int x = 2;
        int y = 1;

        boolean result = areAdjacent(permutation, x, y);

        if (result) {
            System.out.println(x + " and " + y + " are adjacent.");
        } else {
            System.out.println(x + " and " + y + " are not adjacent.");
        }
    }
}