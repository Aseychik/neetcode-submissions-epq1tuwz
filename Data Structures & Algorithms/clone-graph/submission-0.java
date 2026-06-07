/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node res = new Node(node.val);
        Deque<Node> deque1 = new ArrayDeque<>();
        Deque<Node> deque2 = new ArrayDeque<>();
        deque1.push(res);
        deque2.push(node);
        HashMap<Node, Node> hm = new HashMap<>();
        hm.put(node, res);
        while (!deque1.isEmpty()) {
            Node t1 = deque1.pop();
            Node t2 = deque2.pop();
            if (!t2.neighbors.isEmpty()) {
                for (Node n : t2.neighbors) {
                    if (!hm.containsKey(n)){
                        Node copyN = new Node(n.val);
                        t1.neighbors.add(copyN);
                    
                        deque1.push(copyN);
                        deque2.push(n);
                        hm.put(n, copyN);
                    }
                    else {
                        t1.neighbors.add(hm.get(n));
                    }
                }
            }
        }
        return res;

    }
}