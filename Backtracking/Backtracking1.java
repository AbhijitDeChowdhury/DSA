import java.util.*;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> result = new HashSet<>();
       findPermutationHelper(s, "", result);
        return new ArrayList<>(result);
        }
        private void findPermutationHelper(String s, String perm, Set<String> result){
            if(s.length() == 0){
            result.add(perm);
            return;
            }
            for(int i = 0; i < s.length(); i++){
                char currChar = s.charAt(i);
                String newS = s.substring(0, i) + s.substring(i + 1);
                findPermutationHelper(newS, perm + currChar, result);
            }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String s = "ABC";
        ArrayList<String> permutations = sol.findPermutation(s);
        System.out.println("All permutations of " + s + " are:");
        for (String p : permutations) {
            System.out.println(p);
        }
    }
    
}