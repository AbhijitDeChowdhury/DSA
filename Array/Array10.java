class Kadane{
    public static void findMaxSubarray(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0){
                sum = 0;
            }
        }
        System.out.println("Maximum SubArray Sum = " + maxSum);
    }
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        findMaxSubarray(arr);
    }
}