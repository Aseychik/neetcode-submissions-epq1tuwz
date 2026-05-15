/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int p = 0;
        while (l1 != null) {
            res.val += l1.val + p;
            p = res.val / 10;
            res.val %= 10;
            if (l1.next != null || p != 0)
                res.next = new ListNode(0);
            
            l1 = l1.next;
            if (res.next != null)
                res = res.next;
        }
        res.val += p;
        res = head;
        p = 0;
        
        while (l2 != null) {
            res.val += l2.val + p;
            p = res.val / 10;
            res.val %= 10;
            if ((l2.next != null || p != 0) && res.next == null) {
                res.next = new ListNode(0);
            }
            if (res.next != null)
                res = res.next;
            l2 = l2.next;
        }
        while (p != 0) {
            res.val += p;
            p = res.val / 10;
            res.val %= 10;
            if (p != 0 && res.next == null)
                res.next = new ListNode(0);
            
            if (res.next != null)
                res = res.next;
        }
        return head;
    }
}
