class Kadane {
    public static void findMaxSubarraysum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;  // Initialize max sum with smallest integer
        int sum = 0;                     // Current sum of subarray

        for (int i = 0; i < n; i++) {
            sum += arr[i];               // Add current element to sum
            maxSum = Math.max(sum, maxSum);  // Update maxSum if current sum is larger
            if (sum < 0) {               // If sum becomes negative, reset it
                sum = 0;
            }
        }

        System.out.println("Maximum SubArray Sum = " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        findMaxSubarraysum(arr);
    }
}
