import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n-1][n-1] != 0)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        int[] d = {-1, 0, 1};

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1], len = p[2];

            if (r == n-1 && c == n-1)
                return len;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nr = r + i, nc = c + j;

                    if (nr >= 0 && nc >= 0 && nr < n && nc < n
                        && grid[nr][nc] == 0) {
                        q.add(new int[]{nr, nc, len + 1});
                        grid[nr][nc] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
