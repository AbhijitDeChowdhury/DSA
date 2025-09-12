import java.util.*;

class SubArray {
    public static void printSubArrays(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println("Maximum SubArray Sum = " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printSubArrays(arr);
    }
}
