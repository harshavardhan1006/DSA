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
    static List<List<Integer>> list;
    private static void fun(TreeNode root,int lev){
        if(root == null) return;
        if(list.size() == lev) list.add(new ArrayList<>());
        list.get(lev).add(root.val);
        fun(root.left,lev+1);
        fun(root.right,lev+1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        list = new ArrayList<>();
        fun(root,0);
        for(int i=0;i<list.size();i++){
            List<Integer> li = list.get(i);
            // System.out.println(li);
            if(i % 2 == 0){
                if(li.get(0) % 2 == 0) return false;
                int j = 1;
                while(j < li.size()){
                    if( (li.get(j) <= li.get(j-1)) || li.get(j) % 2 == 0) return false;
                    j++;
                }
            }else{
                if(li.get(0) % 2 == 1) return false;
                int j = 1;
                while(j < li.size()){
                    if( (li.get(j) >= li.get(j-1)) || li.get(j) % 2 == 1) return false;
                    j++;
                }
            }
        }
        return true;
    }
}