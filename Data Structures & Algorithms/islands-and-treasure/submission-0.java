class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    deque.push(new int[] {i, j, 0});
                    while (!deque.isEmpty()) {
                        int[] t = deque.removeLast();
                        if (t[0] > 0 && grid[t[0] - 1][t[1]] > 0) {
                            if (t[2] + 1 < grid[t[0] - 1][t[1]]) {
                                grid[t[0] - 1][t[1]] = t[2] + 1;
                                deque.push(new int[] {t[0] - 1, t[1], t[2] + 1});
                            }
                        }
                        if (t[0] < n - 1 && grid[t[0] + 1][t[1]] > 0) {
                            if (t[2] + 1 < grid[t[0] + 1][t[1]]) {
                                grid[t[0] + 1][t[1]] = t[2] + 1;
                                deque.push(new int[] {t[0] + 1, t[1], t[2] + 1});
                            }
                        }
                        if (t[1] > 0 && grid[t[0]][t[1] - 1] > 0) {
                            if (t[2] + 1 < grid[t[0]][t[1] - 1]) {
                                grid[t[0]][t[1] - 1] = t[2] + 1;
                                deque.push(new int[] {t[0], t[1] - 1, t[2] + 1});
                            }
                        }
                        if (t[1] < m - 1 && grid[t[0]][t[1] + 1] > 0) {
                            if (t[2] + 1 < grid[t[0]][t[1] + 1]) {
                                grid[t[0]][t[1] + 1] = t[2] + 1;
                                deque.push(new int[] {t[0], t[1] + 1, t[2] + 1});
                            }
                        }
                    }
                }
            }
        }
    }
}
