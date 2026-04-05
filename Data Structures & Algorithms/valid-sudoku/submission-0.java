class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] hor = new boolean[9][9], vert = new boolean[9][9];
        boolean[][][] kv = new boolean[3][3][9];

        int t;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] - '.' != 0) {
                    t = board[i][j] - '1';
                    if (kv[i / 3][j / 3][t]) return false;
                    kv[i / 3][j / 3][t] = true;
                    if (hor[i][t]) return false;
                    hor[i][t] = true;
                    if (vert[j][t]) return false;
                    vert[j][t] = true;
                }
            }
        }
        return true;
    }
}
