package house_robber_iii;


import java.util.HashMap;

// Definition for a binary tree node.
class TreeNode {
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

class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        // return dfs(root, memo);
        return Math.max(dfs(root)[0], dfs(root)[1]) ;
    }

    private int dfs(TreeNode node, HashMap<TreeNode, Integer> memo) {
        if (node == null) return 0;
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int robCurrent = node.val;
        if (node.left != null){
            robCurrent += dfs(node.left.left, memo) + dfs(node.left.right, memo);
        }
        if (node.right != null){
            robCurrent += dfs(node.right.left, memo) + dfs(node.right.right, memo);
        }

        int skipCurrent = 0;
        skipCurrent = dfs(node.left, memo) + dfs(node.right, memo);

        int result = Math.max(robCurrent, skipCurrent);
        memo.put(node, result);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int robCurrent = node.val + left[1] + right[1];
        int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{robCurrent, skipCurrent};

    }


}