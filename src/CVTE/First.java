package CVTE;

public class First {
    public static void partition(int[] arr, int pivot) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;

        while (i <= right) {
            if (arr[i] < pivot) {
                swap(arr, i, left);
                i++;
                left++;
            } else if (arr[i] > pivot) {
                swap(arr, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,3,6,2};
        partition(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
