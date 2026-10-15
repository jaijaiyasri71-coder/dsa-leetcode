class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    int solve(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target)
                return 1;
            return 0;
        }

        return solve(nums, i + 1, sum + nums[i], target)
             + solve(nums, i + 1, sum - nums[i], target);
    }
}
