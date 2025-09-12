import java.util.*;
class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String[] testCases = {"(()", ")()())", "()(())"};
        for (String s : testCases) {
            System.out.println("Input: " + s + " -> Longest valid parentheses length: " + maxLength(s));
        }
    }
}