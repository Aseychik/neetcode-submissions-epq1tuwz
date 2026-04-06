class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();
        int[] tem = temperatures;
        int[] t;

        //for (int i = 0; i < res.length; i++) res[i] = 0;

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && st.peek()[0] < tem[i]) {
                t = st.pop();
                res[t[1]] = i - t[1];
            }
            st.push(new int[] { tem[i], i });
        }
        return res;
    }
}
