import java.util.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        Node temp = head;
        int count = 0;

        // check if at least k nodes exist
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;
        count = 0;

        // reverse k nodes
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // recursion for next group
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev; // new head after reversal
    }

    // utility function to print linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size and elements
        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // input k
        int k = sc.nextInt();

        Solution sol = new Solution();
        Node newHead = sol.reverseKGroup(head, k);

        // print result
        sol.printList(newHead);

        sc.close();
    }
}
