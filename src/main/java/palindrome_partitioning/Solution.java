package palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, s, path, result);
        return result;
    }

    private static void backtrack(int start, String s, List<String> path, List<List<String>> result) {
        // 如果start等于s的长度，说明已经遍历完了，加入结果
        if (start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        // 从start开始遍历
        for (int end = start; end < s.length(); end++) {
            // 如果不是回文，就跳过
            if (isPalindrome(s, start, end)){
                // 如果是回文，就加入path
                path.add(s.substring(start,end + 1));
                // 然后递归处理剩余部分
                backtrack(end + 1, s, path, result);
                // 然后回溯
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome (String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(partition("aabba")); // [["a", "a", "b"], ["aa", "b"]]
        System.out.println(partition("a"));   // [["a"]]
    }
}