import java.util.*;

class Solution {
    Stack<Integer> s;
    Stack<Integer> Mins;

    public Solution() {
        s = new Stack<>();
        Mins = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        s.push(x);
        if (Mins.isEmpty() || x <= Mins.peek()) {
            Mins.push(x);
        } else {
            Mins.push(Mins.peek());
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        Mins.pop();
        System.out.println("Popped: " + s.pop());
    }

    // Returns top element of the Stack
    public int peek() {
        if (s.isEmpty()) {
            return -1;
        }
        return s.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (Mins.isEmpty()) {
            return -1;
        }
        return Mins.peek();
    }

    // Main method
    public static void main(String[] args) {
        Solution stack = new Solution();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.push(1);
        stack.push(-8);

        System.out.println("Minimum: " + stack.getMin());
        stack.pop();
        System.out.println("Top: " + stack.peek());
        System.out.println("Minimum: " + stack.getMin());
    }
}
