import java.util.*;

class Solution {
    static String decodeString(String s) {
        // Stack for numbers
        Stack<Integer> s1 = new Stack<>();
        // Stack for strings
        Stack<String> s2 = new Stack<>();

        String current = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If digit, build the number
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current number and string
                s1.push(k);
                s2.push(current);
                // Reset for next
                current = "";
                k = 0;
            } else if (ch == ']') {
                // Pop string and repeat count
                StringBuilder temp = new StringBuilder(s2.pop());
                int a = s1.pop();
                for (int i = 0; i < a; i++) {
                    temp.append(current);
                }
                current = temp.toString();
            } else {
                // Normal character, add to current
                current += ch;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        System.out.println(decodeString(str)); 
    }
}
