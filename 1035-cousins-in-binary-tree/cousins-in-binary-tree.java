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
    static int xp;
    static int yp;
    static int xl,yl;
    private static void fun(TreeNode root,int x,int y,int lev){
        if(root == null) return;
        if(root.left != null && root.left.val == x){
            xl = lev;
            xp = root.val;
        }
        if(root.right != null && root.right.val == x){
            xl = lev;
            xp = root.val;
        }
        if(root.left != null && root.left.val == y){
            yl = lev;
            yp = root.val;
        }
        if(root.right != null && root.right.val == y){
            yl = lev;
            yp = root.val;
        }
        fun(root.left,x,y,lev+1);
        fun(root.right,x,y,lev+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        xp = -1;
        yp = -1;
        xl = -1;yl = -1;
        fun(root,x,y,0);
        return xl == yl && xp != yp;
    }
}