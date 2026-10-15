class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(
            helper(nums, 0, n - 2),
            helper(nums, 1, n - 1)
        );
    }

    int helper(int[] nums, int start, int end) {
        int a = 0, b = 0;

        for (int i = start; i <= end; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }

        return b;
    }
}
