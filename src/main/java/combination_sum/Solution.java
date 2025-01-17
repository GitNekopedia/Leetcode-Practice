package combination_sum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, new ArrayList<>(), candidates, result);
        return result;
    }

    private void backtrack(int start, int target, ArrayList<Integer> path, int[] candidates, List<List<Integer>> result) {
        // 如果target为0加入结果
        if (target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        // 如果target<0说明找不到了，进行剪枝
        if (target < 0){
            return;
        }

        // 从start开始遍历
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(i, target - candidates[i], path, candidates, result);
            path.remove(path.size() - 1);
        }
    }
}