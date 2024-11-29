package construct_binary_tree_from_inorder_and_postorder_traversa;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    int post[];
    Map<Integer, Integer> inorderMap = new HashMap<>();
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
        post = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(0, inorder.length-1, 0, postorder.length-1);
        return root;

    }
    public TreeNode buildTree(int inorderStart, int inorderEnd, int postOrderStart, int postOrderEnd){
        if (inorderStart > inorderEnd || postOrderStart > postOrderEnd){
            return null;
        }
        int rootVal = post[postOrderEnd];
        Integer rootIndex = inorderMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(inorderStart, rootIndex - 1, postOrderStart, postOrderStart + rootIndex - inorderStart - 1 );
        node.right = buildTree(rootIndex + 1, inorderEnd, postOrderStart + rootIndex - inorderStart , postOrderEnd -1);
        return node;
    }
}
