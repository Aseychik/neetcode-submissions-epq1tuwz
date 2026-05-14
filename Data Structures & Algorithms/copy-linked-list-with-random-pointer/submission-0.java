/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();

        Node h = head;
        while (h != null) {
            hm.put(h, new Node(h.val));
            h = h.next;
        }
        h = head;
        Node newHead = hm.get(h);
        Node newH = newHead;
        while (h != null) {
            newH.next = hm.get(h.next);
            newH.random = hm.get(h.random);
            h = h.next;
            newH = newH.next;
        }
        return newHead;
    }
}
