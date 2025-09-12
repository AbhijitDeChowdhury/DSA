import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    Node head;

    public static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length of list
        Node curr = head;
        int length = 1;
        while (length <= k || curr.next != null) {
            curr = curr.next;
            length++;
        }

        // If k is greater than length, take modulo
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Make list circular
        curr.next = head;

        // Traverse to (length - k)th node
        int stepsToNewHead = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Break the circle
        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution list = new Solution();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        System.out.println("Original List:");
        list.printList(list.head);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of K: ");
        int k = sc.nextInt();

        list.head = rotate(list.head, k);

        System.out.println("Rotated List:");
        list.printList(list.head);
    }
}
