package validparentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // 创建一个栈
        Stack<Character> stack = new Stack<Character>();
        /*
        (({})
        }))

        ({}))
        })
        */
        // 遍历字符串，遇到左括号就把对应的右括号添加到栈里
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
            // 遍历到非左括号，检测是否与栈顶的括号一致
                return false;
            } else if (s.charAt(i) == stack.peek()) {
                // 遍历到右括号，消掉
                stack.pop();
            }
        }
        return stack.isEmpty();


    }
}