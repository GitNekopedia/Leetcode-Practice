package subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> path, List<List<Integer>> result) {

        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> subsets = s.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(subsets);
    }
}