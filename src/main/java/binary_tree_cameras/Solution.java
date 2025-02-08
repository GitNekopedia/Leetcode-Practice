package binary_tree_cameras;

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
    /*
    递归遍历（后序遍历）
    对于每个节点：

    递归地计算左子树和右子树的状态。
    根据左右子节点状态决定当前节点的状态：
    如果任一子节点状态为 0（未监控）：当前节点必须安装摄像头，返回状态 2，同时计数器加 1。
    如果任一子节点状态为 2（子节点安装了摄像头）：当前节点就可以认为被监控，返回状态 1。
    否则（左右子节点都是状态 1）：当前节点没有摄像头，也没有被覆盖，返回状态 0。
    处理根节点
    最后，在递归结束后需要检查根节点的状态。如果根节点的状态为 0，说明根节点没有被监控，则需要额外安装一个摄像头。

    统计摄像头数
    通过递归过程中安装摄像头的次数，得到最终所需的最小摄像头数量。
    */

    private int count = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0){
            count++;
        }
        return count;
    }

    // 定义返回值：
    // 0 表示该节点未被监控
    // 1 表示该节点已被监控但没有摄像头
    // 2 表示该节点安装了摄像头

    private int dfs(TreeNode root) {
        if (root == null){
            return 1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0){
            count++;
            return 2;
        }

        if (left == 2 || right == 2){
            return 1;
        }

        return 0;
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
