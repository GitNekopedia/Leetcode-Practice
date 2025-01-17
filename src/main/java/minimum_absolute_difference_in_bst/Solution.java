package minimum_absolute_difference_in_bst;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;
        inorderTraversal(node.right);

    }
    private void inorderTraversal2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, cur.val - prev.val);
            }
            prev = cur;
            cur = cur.right;
        }
    }
}