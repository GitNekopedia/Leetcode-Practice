package evaluate_reverse_polish_notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        Integer num3 = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (tokens[i].equals("+")) {
                    num3 = num1 + num2;
                } else if (tokens[i].equals("-")) {
                    num3 = num2 - num1;
                } else if (tokens[i].equals("*")) {
                    num3 = num1 * num2;
                } else if (tokens[i].equals("/")) {
                    num3 = num2 / num1;
                }
                stack.push(num3);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[] {"4","3","-"}));

    }

    public void add(int a, int b){




        System.out.println(c);
    }
}