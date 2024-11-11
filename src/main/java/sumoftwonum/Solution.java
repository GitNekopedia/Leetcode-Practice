package com.leetcode.sumoftwonum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetNum = target - nums[i];
            if (hm.containsKey(targetNum)){
                // 有符合要求的另一个数
                int j = hm.get(targetNum);
                return new int[]{j,i};
            } else {
                // 没找到另一个数
                hm.put(nums[i], i);
            }
        }
        return null;
    }
}

