import java.util.*;
class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.size() == 0){
                    return false;
                }
                if(st.peek() == '(' && s.charAt(i) == ')' || st.peek() == '{' && s.charAt(i) == '}' || st.peek() == '[' && s.charAt(i) == ']'){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String[] testCases = {"[{()}]", "[()()]{}", "(]", "([{]})"};
        for (String s : testCases) {
            System.out.println("Input: " + s + " -> Output: " + (isBalanced(s) ? "true" : "false"));
        }
    }
}
