import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dhead = new ListNode(0);
        ListNode l3 = dhead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int l1val = (l1 != null) ? l1.val : 0;
            int l2val = (l2 != null) ? l2.val : 0;

            int currsum = l1val + l2val + carry;
            carry = currsum / 10;
            int lastdigit = currsum % 10;

            ListNode newnode = new ListNode(lastdigit);
            l3.next = newnode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) {
            ListNode newnode = new ListNode(carry); 
            l3.next = newnode;
        }

        return dhead.next;
    }

    public void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(", ");
            }
            head = head.next;
        }
        System.out.println("]");
    }
    
    public static void main (String[] args){
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        solution.printList(l1);
        solution.printList(l2);

        ListNode result = solution.addTwoNumbers(l1, l2);
        solution.printList(result);
    }
}
