class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('(', 1);
        hm.put('[', 2);
        hm.put('{', 3);
        hm.put(')', -1);
        hm.put(']', -2);
        hm.put('}', -3);

        char[] ch = s.toCharArray();
        int t;

        for (char c : ch) {
            t = hm.get(c);
            if (t > 0) stack.push(t);
            else if (stack.size() == 0 || stack.pop() != -t) return false;
        }
        if (stack.size() != 0) return false;
        return true;
    }
}
