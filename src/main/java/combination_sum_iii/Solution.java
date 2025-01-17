package combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findCombination(1,k,n,path,result);
        return result;
    }

    private void findCombination(int start, int k, int n, List<Integer> path, List<List<Integer>> result) {

        if (path.size() == k){
            int sum = 0;
            for (Integer num : path) {
                sum += num;
            }
            if (sum == n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            findCombination(i + 1, k, n, path, result);
            path.remove(path.size() - 1);
        }
    }

}