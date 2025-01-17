package combination;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        // 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
        // 你可以按 任何顺序 返回答案。

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(1, n, k, path, result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {


        // 符合长度k就把结果记录下来
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历start到n数字
        // [1, 4]
        // 1 2 3 4
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i+1, n, k, path, result);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}