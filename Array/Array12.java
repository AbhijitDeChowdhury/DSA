import java.util.Arrays;

class Solution {
    public static int[] ArrayFact(int[] arr) {
        int n = arr.length;
        int[] newarr = new int[n];
        int fact = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                newarr[i] = 1; // factorial(0) = 1
            } else {
                fact *= arr[i];
                newarr[i] = fact;
            }
        }
        return newarr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Factorial Array: " + Arrays.toString(ArrayFact(arr)));
    }
}
