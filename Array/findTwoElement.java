import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;

        // Expected sum and sum of squares for numbers from 1 to n
        int s = (n * (n + 1)) / 2;
        int ssq = (n * (n + 1) * (2 * n + 1)) / 6;

        int missing = 0, repeating = 0;

        // Subtract actual values from expected sums
        for (int i = 0; i < n; i++) {
            s -= arr[i];
            ssq -= arr[i] * arr[i];
        }

        // Let x = missing, y = repeating
        // s = x - y
        // ssq = x^2 - y^2 = (x - y)(x + y) = s * (x + y)
        // => x + y = ssq / s
        // => x = (s + ssq / s) / 2
        // => y = x - s
        missing = (s + ssq / s) / 2;
        repeating = missing - s;

        ArrayList<Integer> res = new ArrayList<>();
        res.add(repeating);
        res.add(missing);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};
        ArrayList<Integer> ans = findTwoElement(arr);

        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}