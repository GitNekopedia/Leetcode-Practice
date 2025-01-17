package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, path, target, candidates, result );
        return result;
    }

    private void backtrack(int start, List<Integer> path, int target, int[] candidates, List<List<Integer>> result) {
        // 如果等于目标值，加入结果集
        if (target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        // 如果超过了目标值，进行剪枝
        if (target < 0){
            return;
        }

        // 遍历candidates
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字大于目标值，直接停止
            if (candidates[i] > target) break;

            // 跳过重复的数字（去重逻辑）
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrack(i + 1, path, target - candidates[i], candidates, result);
            path.remove(path.size() - 1);
        }
    }
}