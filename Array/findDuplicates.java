import java.util.ArrayList;

class Solution {

    public static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        // traverse each element in the array
        for (int i = 0; i < arr.length; i++) {
            int ct = 0;
            for(int val : ans){
                if(arr[i] == val){
                    ct++;
                    break;
                }
            }
            if(ct > 0){
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]){
                    ct++;
                    break;
                }
            }
            if(ct > 0){
                ans.add(arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int[] arr = {2, 3, 1, 2, 3};
        System.out.print("[");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println("]");
        System.out.println();
        ArrayList<Integer> res = findDuplicates(arr);
        System.out.print("[");
        for (int ele : res) {
            System.out.print(ele + " ");
        }
        System.out.println("]");
        System.out.println();
    }
}