class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] p : points) {
            queue.add(p);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                res[i] = queue.poll();
            }
        }
        return res;
    }
}
