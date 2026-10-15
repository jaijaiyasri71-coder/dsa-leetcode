class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] group = new int[n + 1];

        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];

            if (group[a] == 0 && group[b] == 0) {
                group[a] = 1;
                group[b] = -1;
            }
            else if (group[a] == group[b]) {
                return false;
            }
            else if (group[a] == 0) {
                group[a] = -group[b];
            }
            else if (group[b] == 0) {
                group[b] = -group[a];
            }
        }

        return true;
    }
}
