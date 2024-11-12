package hasPathSum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
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

    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        queue.add(root);
        sumQueue.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            int currentSum = sumQueue.poll();
            if (currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
                return true;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
                sumQueue.add(currentSum + currentNode.left.val);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                sumQueue.add(currentSum + currentNode.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSumBFS(root.left, targetSum - root.val) || hasPathSumBFS(root.right, targetSum - root.val);
    }
}