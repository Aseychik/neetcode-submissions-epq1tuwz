class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles)
            maxPile = Math.max(maxPile, pile);
        
        int left = 1, right = maxPile;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = cfh(piles, mid);
            
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public int cfh(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res += (pile + k - 1) / k;
        }
        return res;
    }
}
