package com.leetcode.hashintersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length==0 || nums2 == null || nums2.length==0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                resSet.add(i);
            }
        }
//        System.out.println(resSet);
        int[] res = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            res[j++] = i;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

    }
}