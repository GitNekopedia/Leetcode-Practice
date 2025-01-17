package subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result){
        // 加入结果集

        result.add(new ArrayList<>(path));


        // 遍历数组
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}