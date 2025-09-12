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
    public static void removeLoop(Node head) {
        // code here
        if(head == null){
            return;
        }
        Node hare = head;
        Node turtle = head;
        Node pre = null;
        Node ptr = head;

        while(hare != null && hare.next != null){
            hare = hare.next.next;
            pre = turtle;
            turtle = turtle.next;
            if(hare == turtle){
                break;
            }
        }
        if (turtle != hare) return;

        while (turtle != hare) {
            pre = hare;
            turtle = turtle.next;
            hare = hare.next;
        }
        pre.next = null;
        return;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "  ");
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

        list.printList(list.head);
        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;

        removeLoop(list.head);

        System.out.println("Linked List after removing loop:");
        list.printList(list.head);
    }
}