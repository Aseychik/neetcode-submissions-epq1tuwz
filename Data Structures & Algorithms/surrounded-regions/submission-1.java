class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i][j] == 'X' ? -1 : 0;
            }
        }
        Deque<int[]> deque = new ArrayDeque<>();
        Deque<int[]> visited = new ArrayDeque<>();
        boolean isEscape = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && map[i][j] == 0) {
                    deque.push(new int[]{i, j});
                    map[i][j] = 2;
                    while (!deque.isEmpty()) {
                        int[] t = deque.pop();
                        int k = t[0], l = t[1];
                        visited.push(new int[]{k, l});
                        if (k == 0 || k == n - 1 || l == 0 || l == m - 1) isEscape = true; 
                        if (k > 0 && map[k - 1][l] == 0) {
                            map[k - 1][l] = 2;
                            deque.push(new int[]{k - 1, l});
                        }
                        if (k < n - 1 && map[k + 1][l] == 0) {
                            map[k + 1][l] = 2;
                            deque.push(new int[]{k + 1, l});
                        }
                        if (l > 0 && map[k][l - 1] == 0) {
                            map[k][l - 1] = 2;
                            deque.push(new int[]{k, l - 1});
                        }
                        if (l < m - 1 && map[k][l + 1] == 0) {
                            map[k][l + 1] = 2;
                            deque.push(new int[]{k, l + 1});
                        }
                    }
                    if (!isEscape) {
                        while (!visited.isEmpty()) {
                            int[] pos = visited.pop();
                            board[pos[0]][pos[1]] = 'X';
                        }
                    }
                    else {
                        visited = new ArrayDeque<>();
                    }
                    isEscape = false;
                }
            }
        }
    }
}
