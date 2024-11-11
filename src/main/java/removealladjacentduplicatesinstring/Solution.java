package removealladjacentduplicatesinstring;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        // abbaca
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            // 遍历字符串，把字母放到栈中
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.isEmpty() || s.charAt(i) != sb.charAt(sb.length() - 1)) {
                sb.append(s.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates2("abbaca"));
    }
}