package non_decreasing_subsequences;

import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, new ArrayList<Integer>(), nums, result);
        return result;
    }

    private void backtrack(int start, ArrayList<Integer> path, int[] nums, List<List<Integer>> result) {


        if (path.size() > 1 && path.size() <= nums.length ) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {



            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)){
                continue;
            }
            if (used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtrack(i + 1, path, nums, result);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> subsequences = s.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(subsequences.toString());
    }
}