class Solution {
    public int maxProfit(int[] prices) {
        int lc = prices[0];
        int hc = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lc) lc = prices[i];

            hc = Math.max(hc, prices[i] - lc);
        }
        return hc;
    }
}
