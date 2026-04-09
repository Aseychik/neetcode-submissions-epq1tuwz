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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode s = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        head = s;

        for (int i = 0; i < (len - 1) / 2; i++) {
            head = head.next;
        }
        ListNode sec = reverseList(head.next);
        head.next = null;
        head = s;
        ListNode t;
        for (int i = 0; i < (len) / 2; i++) {
            if (head.next == null) {
                head.next = sec;
                return;
            }
            t = head.next;
            head.next = sec;
            head = head.next;
            if (sec.next != null) {
                sec = sec.next;
                head.next = t;
                head = head.next;
            }
            else {
                head.next = t;
                t.next = null;
                return;
            }
        }
        return;
    }

    public ListNode reverseList(ListNode head) {
        ListNode last, next;
        if (head == null) return null;
        if (head.next == null) return head;
        last = head;
        head = head.next;
        last.next = null;
        while (!(head.next == null)) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        head.next = last;
        return head;
    }
}
