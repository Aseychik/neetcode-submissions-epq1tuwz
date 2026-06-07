class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = n * m;
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = grid[i][j] == 0 ? -1 : grid[i][j] == 1 ? res : 0;
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    deque.push(new int[] {i, j, 0});
                    while (!deque.isEmpty()) {
                        int[] t = deque.removeLast();
                        int k = t[0], l = t[1];
                        if (k > 0 && grid[k - 1][l] == 1 && map[k - 1][l] > t[2] + 1) {
                            map[k - 1][l] = t[2] + 1;
                            deque.push(new int[] {k - 1, l, t[2] + 1});
                        }
                        if (k < n - 1 && grid[k + 1][l] == 1 && map[k + 1][l] > t[2] + 1) {
                            map[k + 1][l] = t[2] + 1;
                            deque.push(new int[] {k + 1, l, t[2] + 1});
                        }
                        if (l > 0 && grid[k][l - 1] == 1 && map[k][l - 1] > t[2] + 1) {
                            map[k][l - 1] = t[2] + 1;
                            deque.push(new int[] {k, l - 1, t[2] + 1});
                        }
                        if (l < m - 1 && grid[k][l + 1] == 1 && map[k][l + 1] > t[2] + 1) {
                            map[k][l + 1] = t[2] + 1;
                            deque.push(new int[] {k, l + 1, t[2] + 1});
                        }
                    }
                }
            }
        }
        res = 0;
        int t = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && map[i][j] == t) return -1;
                res = Math.max(res, map[i][j]);
            }
        }
        return res;
    }
}
