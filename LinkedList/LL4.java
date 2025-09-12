import java.util.*;

// Node class
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    static Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node pre = null;
        while(curr != null){
            Node nbr = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nbr;
        }
        return pre;
    }
    static Node remove(Node head){
        while (head != null && head.data == 0) {
            head = head.next;
        }
        if (head == null) {
            return new Node(0);
        }
        return head;
    }

    static Node addTwoLists(Node head1, Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Node ptr1 = reverse(head1);
        Node ptr2 = reverse(head2);
        int carry = 0;
        Node dummy = new Node(-1);
        Node curr = dummy;

        while(ptr1 != null || ptr2 != null || carry != 0){
            int val1 = (ptr1 != null) ? ptr1.data : 0;
            int val2 = (ptr2 != null) ? ptr2.data : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int d = sum % 10;

            curr.next = new Node(d);
            curr = curr.next;

            if(ptr1 != null) ptr1 = ptr1.next;
            if(ptr2 != null) ptr2 = ptr2.next;
        }

        Node result = reverse(dummy.next);
        return remove(result);
    }

    static void printList(Node head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    static Node createList(int[] arr){
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i=1; i<arr.length; i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Main function
    public static void main(String[] args){
        int[] arr1 = {9,9,9};
        int[] arr2 = {1};

        Node head1 = createList(arr1);
        Node head2 = createList(arr2);

        System.out.print("First List: ");
        printList(head1);
        System.out.print("Second List: ");
        printList(head2);

        Node result = addTwoLists(head1, head2);

        System.out.print("Result: ");
        printList(result);
    }
}
