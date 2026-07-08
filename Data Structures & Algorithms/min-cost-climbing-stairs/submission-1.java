class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int c = cost[0];
        int pos = 0;
        int a = c + cost[1], b = 0;
        while (pos < cost.length - 2) {
            a = Math.min(a, c + cost[pos + 1]);
            b = Math.min(a, c) + cost[pos + 2];

            c = a;
            a = b;
            b = 0;
            pos++;
        }
        int res = Math.min(a, c);
        
        c = cost[1];
        pos = 1;
        a = c + cost[2]; 
        b = 0;
        while (pos < cost.length - 2) {
            a = Math.min(a, c + cost[pos + 1]);
            b = Math.min(a, c) + cost[pos + 2];

            c = a;
            a = b;
            b = 0;
            pos++;
        }
        return Math.min(res, Math.min(a, c));
    }
}
