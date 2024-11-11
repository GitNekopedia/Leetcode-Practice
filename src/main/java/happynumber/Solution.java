package com.leetcode.happynumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        /*
            示例 1：
            输入：n = 19
            输出：true
            解释：
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1

            示例 2：
            输入：n = 2
            输出：false

            示例 3"
            11
            1^2 + 1^2 = 2
            2^2 = 4   <------------
            4^2 = 16
            1^2 + 6^2 = 37
            3^2 + 7^2 = 9+49 = 58
            5^2 + 8^2 = 25 + 64 = 89
            8^2 + 9^2 = 64 + 81 = 145
            1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42
            4^2 + 2^2 = 20
            2^2 + 0^2 = 4   <------------
       */

        Set<Integer> set = new HashSet<>();
        while (n!=1 && !set.contains(n)){
            set.add(n);
            n = getNextNum(n);
        }
        return n == 1;

    }

    private int getNextNum(int n) {
        int res = 0;
        // 123
        // 1^1 + 2^2 + 3^3
        while (n > 0){
            int temp = n % 10; //3
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}