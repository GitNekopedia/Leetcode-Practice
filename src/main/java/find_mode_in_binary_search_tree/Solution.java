package find_mode_in_binary_search_tree;

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
    Integer prev = null;
    int maxCount = 0;
    int count = 0;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        inorderTraversal(root);
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        // 处理当前节点
        if (prev != null && root.val == prev){
            count++;
        } else {
            count = 1;
        }
        if (count > maxCount){
            maxCount = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == maxCount) {
            modes.add(root.val);
        }
        prev = root.val;

        inorderTraversal(root.right);
    }
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

}
