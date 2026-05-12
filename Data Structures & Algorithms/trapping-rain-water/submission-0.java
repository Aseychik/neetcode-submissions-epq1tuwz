class Solution {
    public int trap(int[] height) {
        int[] maxh = new int[height.length];
        maxh[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            maxh[i] = Math.max(height[i], maxh[i - 1]);
        }
        int res = 0;
        int m2 = -1;
        for (int i = height.length - 1; i > 0; i--) {
            if (height[i] <= m2) {
                int t = Math.min(m2, maxh[i]);
                if (height[i] < t) res += t - height[i];
            }
            else m2 = height[i];
        }
        return res;
    }
}
