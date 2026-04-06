class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
        double last = -1;
        int res = 0;
        double t;
        for (int i = n - 1; i >= 0; i--) {
            t = (double)(target - arr[i][0]) / arr[i][1];
            if (last == -1 || last < t) {
                res += 1;
                last = t;
            }
        }
        return res;
    }
}
