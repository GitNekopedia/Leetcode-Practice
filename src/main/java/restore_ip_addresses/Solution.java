package restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, 0, s, path, result);
        return result;
    }

    private void backtrack(int start, int parts, String s, List<String> path, List<String> result) {

        // 如果分割为4部分，且刚好遍历完字符串，加入结果
        if (parts == 4){
            if (start == s.length()){
                result.add(String.join(".", path));
            }
            return;
        }

        // 遍历字符串
        for (int i = 1; i <= 3; i++) {
            // 如果字符串长度超过了字符串长度，跳过
            if (start + i > s.length()){
                break;
            }
            // 字符串分割
            String part = s.substring(start, start + i);
            // 合法性检验
            if ((part.length() > 1 && part.startsWith("0")) || Integer.parseInt(part) > 255) {
                continue;
            }

            path.add(part);
            backtrack(start + i, parts + 1, s, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 示例输入
        String s1 = "25525511135";
        String s2 = "0000";
        String s3 = "101023";

        // 打印结果
        System.out.println("Input: " + s1);
        System.out.println("Output: " + s.restoreIpAddresses(s1));

    }
}