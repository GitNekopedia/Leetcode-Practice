package permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<Integer>(), result, used);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used){


        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }



        for (int i = 0; i < nums.length; i++) {

            if (used[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i -1]){
                continue;
            }


            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, result, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution s =  new Solution();
        List<List<Integer>> permute = s.permuteUnique(new int[]{1, 1, 2});
        System.out.println(permute);

    }
}
