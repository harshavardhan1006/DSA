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
    private static int fun(TreeNode root,int s){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return s*10+root.val;
        return fun(root.left,s*10+root.val)+fun(root.right,s*10+root.val);
    }
    public int sumNumbers(TreeNode root) {
        return fun(root,0);
    }
}