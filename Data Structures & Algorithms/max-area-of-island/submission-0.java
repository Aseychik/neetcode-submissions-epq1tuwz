class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Deque<int[]> deq = new ArrayDeque<>();
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    deq.push(new int[] {i, j});
                    cnt = 0;
                    while (!deq.isEmpty()) {
                        int[] t = deq.pop();
                        if (visited[t[0]][t[1]] == 0) {
                            visited[t[0]][t[1]] = 1;
                            cnt++;
                            int k = t[0], l = t[1];
                            for (k = t[0] - 1; k < t[0] + 2; k += 2) {
                                if (k >= 0 && l >= 0 && k < grid.length && l < grid[k].length) {
                                    if (grid[k][l] == 1 && visited[k][l] == 0) { 
                                        deq.push(new int[] {k, l});
                                    }
                                }
                            }
                            k = t[0];
                            for (l = t[1] - 1; l < t[1] + 2; l += 2) {
                                if (k >= 0 && l >= 0 && k < grid.length && l < grid[k].length) {
                                    if (grid[k][l] == 1 && visited[k][l] == 0) {
                                        deq.push(new int[] {k, l});
                                    }
                                }
                            }
                        }
                    }
                    
                    res = Math.max(res, cnt);
                }
            }
        }
        return res;
    }
}
