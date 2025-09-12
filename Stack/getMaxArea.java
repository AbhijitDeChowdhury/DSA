import java.util.*;

class Solution {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;

        // Right element
        int[] right = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        s.clear();

        // Left element
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            int w = right[i] - left[i] - 1;
            int area = arr[i] * w;
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea(arr));
    }
}
