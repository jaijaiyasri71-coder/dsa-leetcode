class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;

        for (int n : nums) {
            int c = Math.max(a + n, b);
            a = b;
            b = c;
        }

        return b;
    }
}
