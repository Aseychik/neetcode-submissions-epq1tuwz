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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        int cnt = 1;
        while (h.next != null) {
            h = h.next;
            cnt++;
        }
        if (cnt == 1) {
            return null;
        }
        cnt = cnt - n;
        if (cnt == 0) return head.next;
        h = head;
        while (cnt-- > 1) {
            h = h.next;
        }
        if (h.next == null) return null;
        
        h.next = h.next.next;
        return head;
    }
}
