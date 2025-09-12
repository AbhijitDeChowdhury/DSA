import java.util.*;

class MyStack {
    private ArrayList<Integer> s; 
    private int maxSize;  

    public MyStack(int size) {
        maxSize = size;
        s = new ArrayList<>(size);
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }
        s.add(x);
        System.out.println(x + " pushed into stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return s.remove(s.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return s.get(s.size() - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int val : s) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public boolean isFull() {
        return s.size() == maxSize;
    }
}

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack(5);  // max size 5
        int choice, value;

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    value = stack.pop();
                    if (value != -1)
                        System.out.println("Popped element: " + value);
                    break;
                case 3:
                    value = stack.peek();
                    if (value != -1)
                        System.out.println("Top element: " + value);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
