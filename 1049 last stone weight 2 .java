class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int x : stones)
            sum += x;

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int x : stones) {
            for (int j = sum / 2; j >= x; j--) {
                dp[j] = dp[j] || dp[j - x];
            }
        }

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[j])
                return sum - 2 * j;
        }

        return 0;
    }
}
