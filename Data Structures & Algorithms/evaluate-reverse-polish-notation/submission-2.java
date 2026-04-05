class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int t = 0;
        char c;

        for (String s : tokens) {
            c = s.charAt(0);
            if (s.length() == 1) {
                if (c == '+') stack.push(stack.pop() + stack.pop()); 
                else if (c == '-') stack.push(-(stack.pop() - stack.pop())); 
                else if (c == '*') stack.push(stack.pop() * stack.pop()); 
                else if (c == '/') {
                    t = stack.pop();
                    stack.push(stack.pop() / t);
                } 
                else stack.push(Integer.parseInt(s));
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
