package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node != null){
            path += node.val;
            if (node.left == null && node.right == null){
                paths.add(path);
            } else {
                path += "->";
                constructPaths(node.left, path, paths);
                constructPaths(node.right, path, paths);
            }
        }
    }
}