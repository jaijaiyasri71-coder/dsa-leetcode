
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, ans);
        return ans;
    }

    void generate(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            generate(nums, index + 1, ans);

            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
