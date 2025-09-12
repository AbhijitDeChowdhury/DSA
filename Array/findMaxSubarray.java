class productSubArray{
    public static void findMaxSubarray(int[] arr){
        int n = arr.length;
        int maxProduct = arr[0];
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < n; i++){
            if(arr[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);

            maxProduct = Math.max(maxProduct, max);
        }
        System.out.println("Maximum SubArray Sum = " + maxProduct);
    }
    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        findMaxSubarray(arr);
    }
}