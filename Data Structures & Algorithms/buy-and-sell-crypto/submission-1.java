class Solution {
    public int maxProfit(int[] prices) {
        int lc = prices[0];
        int hc = 0;

        for (int i : prices) {
            lc = Math.min(lc, i);

            hc = Math.max(hc, i - lc);
        }
        return hc;
    }
}
