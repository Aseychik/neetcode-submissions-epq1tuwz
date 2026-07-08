class Solution {
    public int climbStairs(int n) {
        int[] d = new int[3];
        d[0] = 1;
        for (int i = 0; i < n; i++) {
            d[1] += d[0];
            d[2] += d[0];
            d[0] = d[1];
            d[1] = d[2];
            d[2] = 0;
        }
        return d[0];
    }
}
