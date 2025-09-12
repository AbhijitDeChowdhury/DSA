class Solution {
    Node sortedMerge(Node head1, Node head2) {
        if(head1 == null) return head2;
        else if(head2 == null) return head1;

        Node ptr1 = head1;
        Node ptr2 = head2;
        Node dummy = new Node(-1);
        Node ans = dummy;

        while(ptr1 != null && ptr2 != null){
            if(ptr1.data < ptr2.data){
                dummy.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                dummy.next = ptr2;
                ptr2 = ptr2.next;
            }
            dummy = dummy.next;
        }
        if(ptr1 != null) dummy.next = ptr1;
        else dummy.next = ptr2;

        return ans.next;
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        Solution sol = new Solution();
        Node merged = sol.sortedMerge(head1, head2);

        System.out.println("Merged List:");
        sol.printList(merged);
    }
}
