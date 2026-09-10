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
    static int res;
    static int cnt;
    private static int getSum(TreeNode root){
        if(root == null) return 0;
        cnt++;
        int leftsum = getSum(root.left);
        int rightsum = getSum(root.right);
        return root.val+leftsum+rightsum;
    }
    private static void fun(TreeNode root){
        if(root == null) return;
        cnt = 0;
        int sum = getSum(root);
        // System.out.println(cnt);
        if(sum/cnt == root.val) res++;
        fun(root.left);
        fun(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        res = 0;
        fun(root);
        return res;
    }
}