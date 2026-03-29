class LinkedList {
    Node head;
    int length;


    public LinkedList() {
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) return -1;

        Node nn = head;
        for (int i = 0; i < index; i++)
            nn = nn.right;
        
        return nn.value;
    }

    public void insertHead(int val) {
        if (length == 0) {
            head = new Node(val);
            length = 1;
            return;
        }
        
        Node newHead = new Node(val);
        newHead.right = head;

        length++;
        head = newHead;
    }

    public void insertTail(int val) {
        if (length == 0) {
            head = new Node(val);
            length = 1;
            return;
        }

        Node nn = head;

        for (int i = 0; i < length - 1; i++) {
            nn = nn.right;
        }
        nn.right = new Node(val);
        length++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= length) return false;

        if (index == 0) {
            head = head.right;
            length--;
            return true;
        }

        Node nn = head;
        for (int i = 0; i < index - 1; i++)
            nn = nn.right;
        
        nn.right = nn.right.right;
        length--;
        return true;
        
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();

        Node nn = head;
        for (int i = 0; i < length; i++) {
            values.add(nn.value);
            nn = nn.right;
        }
        return values;
    }

    private class Node {
        public Node right;
        public int value;

        public Node() {}

        public Node(int t) {
            value = t;
        }
    }
}