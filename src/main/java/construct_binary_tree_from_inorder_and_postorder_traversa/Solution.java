package construct_binary_tree_from_inorder_and_postorder_traversa;

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0){
            return  null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, new int[]{postorder.length - 1}, 0, inorder.length - 1, inorderMap );
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int[] postIndex, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd){
            return null;
        }
        // 找到根节点
        int rootVal = postorder[postIndex[0]];
        postIndex[0]--;
        // 构建根节点
        TreeNode root = new TreeNode(rootVal);
        // 在中序中找到根节点的位置，将其分为左子树和右子树
        Integer rootIndex = inorderMap.get(rootVal);
        // 构建右子树
        root.right = buildTreeHelper(inorder, postorder, postIndex, rootIndex + 1, inEnd, inorderMap);
        // 构建左子树
        root.left = buildTreeHelper(inorder, postorder, postIndex, inStart, rootIndex - 1, inorderMap);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println(root);
    }
}